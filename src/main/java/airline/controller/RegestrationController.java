package airline.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import airline.model.UserBean;
import airline.serviceclass.UserService;

@Controller
public class RegestrationController {
	@Autowired
	public UserService userService;
	
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new UserBean());

	    return mav;
	  }
		
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("user") UserBean userBean)
	{
		String error = null;
		try {
		userService.register(userBean);
		
		}
		catch(DuplicateKeyException e) {
			error = "This Email is already registered with us";
		}
		catch(Exception e) {
			error = "There seems to be some problem, please try again later.";
		}
		
		ModelAndView mav = new ModelAndView();
	    mav.addObject("error",error);
	    System.out.println(error);
		System.out.println(userBean.getFullName()+userBean.getEmail());
	    mav.addObject("fullname", userBean.getFullName());
	    mav.addObject("message", "dick");
	    if(error!=null){
	    	mav.setViewName("register");
	    }else {
	    	mav.setViewName("Home2");
	    }
	    	// return new ModelAndView("welcome", "fullname", userBean.getFullName());
	    return mav;
	}
	
	
}
