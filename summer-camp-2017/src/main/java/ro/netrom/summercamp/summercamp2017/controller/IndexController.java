package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.announcement.Announcement;
import ro.netrom.summercamp.summercamp2017.comment.Comment;

@Controller
public class IndexController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ObjectMapper objectMapper;

	//Display all the announcements 
	@RequestMapping(value = "/listAnnouncement.html", method = RequestMethod.GET)
	public String displayAnnouncements(Model model) throws JsonParseException, JsonMappingException, IOException {
		List<Announcement> announcements = new ArrayList<>();

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().equals(HttpStatus.OK) && !response.getBody().isEmpty()) {
			announcements = objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Announcement>>() {
			});
		}
		model.addAttribute("modelAnnouncement", announcements);
		model.addAttribute("announcement", new Announcement());
		return "index";
	}

	@RequestMapping(value = "/addAnnouncement.html", method = RequestMethod.GET)
	public String showAnnouncements(Model model) throws JsonParseException, JsonMappingException, IOException {
		List<Announcement> announcements = new ArrayList<>();

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().equals(HttpStatus.OK) && !response.getBody().isEmpty()) {
			announcements = objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Announcement>>() {
			});
		}
		model.addAttribute("modelAnnouncement", announcements);
		model.addAttribute("announcement", new Announcement());
		return "addAnnouncement";
	}

	@RequestMapping(value = "/addAnnouncement.html", method = RequestMethod.POST)
	public String addAnnouncement(@ModelAttribute("announcement") Announcement announcement, BindingResult results) {

		// s String url =
		// "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/save.do";

		// ResponseEntity<Announcement> response =
		// restTemplate.postForEntity(url, announcement, Announcement.class);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		// model.addAttribute("addAnnouncement", announcement);

		HttpEntity<Announcement> entity = new HttpEntity<Announcement>(announcement, httpHeaders);
		ResponseEntity<String> response = restTemplate.postForEntity(
				"http://summercamp.api.stage03.netromsoftware.ro/api/announcement/save.do", entity, String.class);

		if (response.getBody().isEmpty() || !response.getStatusCode().is2xxSuccessful())
			return "error";
		//return "index";

		 return "addAnnouncement";

	}

	@InitBinder
	private void getDateBinder(WebDataBinder dataBinder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));

	}

	@RequestMapping(value = "/listComments.do", method = RequestMethod.GET)
	public String showComment(Model model, Comment announcementId)
			throws JsonParseException, JsonMappingException, IOException {

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/list.do";
		List<Comment> comments = new ArrayList<>();

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().equals(HttpStatus.OK) && !response.getBody().isEmpty()) {
			comments = objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Comment>>() {
			});
		}
		model.addAttribute("modelComments", comments);
		return "listComment";
	}

	/*
	 * public String addComments(Model model, Announcement announcementId){
	 * 
	 * String url =
	 * "http://summercamp.api.stage03.netromsoftware.ro/api/comments/save.do ";
	 * 
	 * //Comment root = getTreeRootNode(); model.addAttribute("node", root);
	 * return null;
	 * 
	 * }
	 */
}
