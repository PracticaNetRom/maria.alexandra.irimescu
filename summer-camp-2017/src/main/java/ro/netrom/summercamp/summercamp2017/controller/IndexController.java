package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.announcement.Announcement;
import ro.netrom.summercamp.summercamp2017.category.Category;
import ro.netrom.summercamp.summercamp2017.comment.Comment;

@Controller
public class IndexController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ObjectMapper objectMapper;

	// Display all the announcements
	@RequestMapping(value = "/listAnnouncement.html", method = RequestMethod.GET)
	public String displayAnnouncements(Model model) throws JsonParseException, JsonMappingException, IOException {
		List<Announcement> announcements = new ArrayList<>();

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().equals(HttpStatus.OK) && !response.getBody().isEmpty()) {
			announcements = objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Announcement>>() {
			});
		}

		List<Category> categories = new ArrayList<>();

		String urlCategories = "http://summercamp.api.stage03.netromsoftware.ro/api/categories/list.do";
		ResponseEntity<String> responseCategories = restTemplate.getForEntity(urlCategories, String.class);

		if (responseCategories.getStatusCode().equals(HttpStatus.OK) && !responseCategories.getBody().isEmpty()) {
			categories = objectMapper.readValue(responseCategories.getBody(), new TypeReference<ArrayList<Category>>() {
			});
		}

		model.addAttribute("categories", categories);

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

	// Add announcements
	@RequestMapping(value = "/addAnnouncement.html", method = RequestMethod.POST)
	public View addAnnouncement(Model model, @ModelAttribute("announcement") Announcement announcement,
			BindingResult results) {

		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/save.do";

		announcement.setCreateDate(new Date());
		ResponseEntity<Announcement> response = restTemplate.postForEntity(url, announcement, Announcement.class);

		model.addAttribute("announcement", response);
		return new RedirectView("/listAnnouncement.html", true);

	}

	// Get announcement by id and show the comments for a specific announcement
	@RequestMapping(value = "/showDetails.html", method = RequestMethod.GET)
	public String getAnnouncementById(Model model, Integer id)
			throws JsonParseException, JsonMappingException, IOException {

		Announcement announcement = null;
		String urlAnnouncement = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/getById.do?announcementId="
				+ id.toString();
		ResponseEntity<String> responseAnnouncement = restTemplate.getForEntity(urlAnnouncement, String.class);

		if (responseAnnouncement.getStatusCode().equals(HttpStatus.OK) && !responseAnnouncement.getBody().isEmpty()) {
			announcement = objectMapper.readValue(responseAnnouncement.getBody(), new TypeReference<Announcement>() {
			});
		}
		model.addAttribute("announcementById", announcement);

		String urlComment = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/list.do?announcementId="
				+ id.toString();
		List<Comment> comments = new ArrayList<>();

		ResponseEntity<String> responseComment = restTemplate.getForEntity(urlComment, String.class);

		if (responseComment.getStatusCode().equals(HttpStatus.OK) && !responseComment.getBody().isEmpty()) {
			comments = objectMapper.readValue(responseComment.getBody(), new TypeReference<ArrayList<Comment>>() {
			});
		}

		model.addAttribute("comments", comments);
		model.addAttribute("addComment", new Comment());

		return "details";
	}

	@InitBinder
	private void getDateBinder(WebDataBinder dataBinder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));

	}

	// Add comment
	@RequestMapping(value = "/addComment.do", method = RequestMethod.POST)
	public String addComments(Model model, @ModelAttribute("comment") Comment comment,
			@RequestParam("announcementId") Integer id,
			@RequestParam(name = "parentId", required = false) Integer parentId, BindingResult results)
			throws JsonParseException, JsonMappingException, IOException {

		String urlAddComment = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/save.do?announcementId="
				+ id.toString() + (parentId != null ? ("&parentId=" + parentId.toString()) : "");

		ResponseEntity<Comment> response = restTemplate.postForEntity(urlAddComment, comment, Comment.class);

		Announcement announcement = null;
		String urlAnnouncement = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/getById.do?announcementId="
				+ id.toString();
		ResponseEntity<String> responseAnnouncement = restTemplate.getForEntity(urlAnnouncement, String.class);

		if (responseAnnouncement.getStatusCode().equals(HttpStatus.OK) && !responseAnnouncement.getBody().isEmpty()) {
			announcement = objectMapper.readValue(responseAnnouncement.getBody(), new TypeReference<Announcement>() {
			});
		}
		model.addAttribute("announcementById", announcement);

		String urlComment = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/list.do?announcementId="
				+ id.toString();
		List<Comment> comments = new ArrayList<>();

		ResponseEntity<String> responseComment = restTemplate.getForEntity(urlComment, String.class);

		if (responseComment.getStatusCode().equals(HttpStatus.OK) && !responseComment.getBody().isEmpty()) {
			comments = objectMapper.readValue(responseComment.getBody(), new TypeReference<ArrayList<Comment>>() {
			});
		}

		model.addAttribute("comments", comments);
		model.addAttribute("addComment", new Comment());

		model.addAttribute("comment", response);
		return "details";

	}

	@RequestMapping(value = "/listCategories.html", method = RequestMethod.GET)
	public String getAllCategories(Model model) throws JsonParseException, JsonMappingException, IOException {
		List<Category> categories = new ArrayList<>();

		String urlCategories = "http://summercamp.api.stage03.netromsoftware.ro/api/categories/list.do";
		ResponseEntity<String> responseCategories = restTemplate.getForEntity(urlCategories, String.class);

		if (responseCategories.getStatusCode().equals(HttpStatus.OK) && !responseCategories.getBody().isEmpty()) {
			categories = objectMapper.readValue(responseCategories.getBody(), new TypeReference<ArrayList<Category>>() {
			});
		}

		model.addAttribute("categories", categories);
		return "index";
	}

	@RequestMapping(value = "/closeAnnouncement.do", method = RequestMethod.POST)
	public String closeAnnouncement(Model model, Announcement announcement,@RequestParam("id") Integer id, String ownerEmail,BindingResult results)
			throws JsonParseException, JsonMappingException, IOException {

		String urlClose = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/close.do?announcementId="
				+ id.toString() + "&ownerEmail=" + ownerEmail.toString();

		ResponseEntity<Announcement> responseClose = restTemplate.postForEntity(urlClose, announcement,
				Announcement.class);

		

		model.addAttribute("closeAnnouncement", responseClose);

		return "index";
	}

	@RequestMapping(value = "/closeAnnouncement.do", method = RequestMethod.GET)
	public String showCloseAnnouncement(Model model, Announcement announcement, Integer id, String ownerEmail)
			throws JsonParseException, JsonMappingException, IOException {

		String urlClose = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/close.do?announcementId="
				+ id.toString() + "&ownerEmail=" + ownerEmail.toString();

		model.addAttribute("close", urlClose);
		return "closeAnnouncement";
	}
}