package airline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import airline.model.LoginBean;
import airline.model.UserBean;
import airline.serviceclass.UserService;

@Controller
@SessionAttributes("fullname")
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/Loogin", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("Loogin");
    mav.addObject("login", new LoginBean());	//this and ModelAttribute should be same name in string ""
    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse res, @ModelAttribute("login") LoginBean loginBean) 
  {

    String error = null;
    ModelAndView mav = new ModelAndView();
    try {
    UserBean userBean = userService.validateUser(loginBean);

    System.out.println("we are here in login process");
    if (null != userBean) {
    	System.out.println("we are here in succesfule login process");
      mav.setViewName("Home2");
      mav.addObject("fullname", userBean.getFullName());
      mav.addObject("email",userBean.getEmail());
      mav.addObject("userid",userBean.getUserid());
    } else {
    	System.out.println("we are here in failure login process");
      mav.setViewName("Loogin");
      error = "Username or Password is wrong!!";

    }
    }
    catch(Exception e){
    	error = "there seems to be some problem, please try again with propeer syntax";
    }
    mav.addObject("errorLoggingIn", error);
    return mav;
  }
  
  
	@RequestMapping(value="/logoutt", method= RequestMethod.GET)
	public ModelAndView logout(String fullname, HttpServletRequest request) {
		request.getSession(true).invalidate();
    	ModelAndView mav = new ModelAndView();
    	System.out.println("we are here in logout");
    	mav.setViewName("logout");
    	mav.addObject("logout","true");
		return mav;

	}

}
