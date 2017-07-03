package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.announcement.Announcement;

@Controller
public class IndexController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ObjectMapper objectMapper;

	//@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	/*public String getIndex() {
		return "index";
	}*/

	@RequestMapping(value = "/listAnnouncement.html", method = RequestMethod.GET)
	public String displayAnnouncements(Model model) throws JsonParseException, JsonMappingException, IOException {
		List<Announcement> announcements = new ArrayList<>();

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().equals(HttpStatus.OK) && !response.getBody().isEmpty()) {
			announcements = objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Announcement>>() {});
		}
		model.addAttribute("modelAnnouncement", announcements);
		return "announcements";
	}

}
