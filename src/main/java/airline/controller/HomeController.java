package airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping(value = "/Home2", method = RequestMethod.GET)
	public String showHomePage() {
		return "Home2";
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
		public String showEmptyPage() {
			return "Home2";
	}
}