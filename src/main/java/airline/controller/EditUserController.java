package airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import airline.dao.EditTicketDao;



@Controller
public class EditUserController {

	@Autowired
	EditTicketDao editTicketDao;
	
	@RequestMapping(value = "/cancelTicketsInitial", method = RequestMethod.GET)
	public ModelAndView cancelTicketsInitial(String fullname, String email) {
		String fullname2= fullname;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cancelticket");
		if(fullname == null)
		{
			fullname2 = "null";
		}
		mav.addObject("fullname",fullname2);
		mav.addObject("email",email);
		return mav;
	}
	
	@RequestMapping(value = "/cancelTickets", method = RequestMethod.GET)
	public ModelAndView cancelTickets(String email, Long flightId) {
		ModelAndView mav = new ModelAndView();
		editTicketDao.cancelTickets(email, flightId);
		mav.setViewName("Home2");
		return mav;
	}
}