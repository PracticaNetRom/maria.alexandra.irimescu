package ro.netrom.summercamp.summercamp2017.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
}
