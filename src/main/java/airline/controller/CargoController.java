package airline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import airline.dao.CityDao;
import airline.dao.FreightInfoDao;
import airline.model.FreightInfoBean;
import airline.serviceclass.CargoHandler;

@Controller
public class CargoController {

	@Autowired 
	FreightInfoDao freightInfoDao;
	
	@Autowired
	CargoHandler cargoHandler;
	
	@Autowired
	CityDao cityDao;
	
	@RequestMapping(value = "/freightInfoInitial", method = RequestMethod.GET)
	public ModelAndView freightInfoInitial(String fullname, Long userid, String email){
		System.out.println(fullname);
		String fullname2 = fullname;
		if(fullname == null)
		{
			fullname2 = "null";
		}
		ModelAndView mav = new ModelAndView();
		List<String> cityList = cityDao.listCity();
		List<String> l1 = new ArrayList<>();
		l1 = cityList;
		System.out.println(cityList);
		mav.addObject("fullname", fullname2);
		mav.addObject("email", email);
		mav.addObject("userid", userid);
		mav.addObject("cityNameList", l1);
		mav.setViewName("freightinformation");
		return mav;
	}
	
	@RequestMapping(value = "/freightInfo", method = RequestMethod.GET)
	public ModelAndView freightInfo(String recepientName, String recepientEmail,
			String recepientMobile, String recepientAddress, String senderName,
			String senderMobile, String cargoSize, String flightDate, String destination, String from,
			String email, String fullname, Long userid){
		ModelAndView mav = new ModelAndView();
		Boolean cargoSizeLarge; 
		if(cargoSize !=null )
			cargoSizeLarge = true;
		else 
			cargoSizeLarge = false;
		
		FreightInfoBean freightInfoBean = cargoHandler.createFreight(recepientName, recepientEmail, recepientMobile, recepientAddress, senderName, senderMobile, cargoSizeLarge,destination,from,flightDate,userid);
		freightInfoDao.createFreight(freightInfoBean);
		mav.addObject("freightInfoBean",freightInfoBean);
		int extraPrice= 0;
		if(freightInfoBean.getCargosizeLarge()==true)
			extraPrice = 20;
		mav.addObject("extraPrice",extraPrice);
		mav.addObject("receiveremail",recepientEmail);
		mav.addObject("loadingDate",flightDate);
		mav.addObject("destaddress",recepientAddress);
		mav.setViewName("totalcargo");
		return mav;
	}
	
	@RequestMapping(value = "/cargoInvoiceInitial", method = RequestMethod.POST)
		public ModelAndView cargoInvoiceInitial(String receiveremail, String destaddress, String loadingDate, String totalprice) {
			System.out.println("receiver email = "+receiveremail + destaddress + loadingDate + totalprice);
			ModelAndView mav = new ModelAndView();
			mav.addObject("receiveremail",receiveremail);
			mav.addObject("destaddress",destaddress);
			mav.addObject("loadingDate",loadingDate);
			mav.addObject("totalprice",totalprice);
			mav.setViewName("cargoInvoice");
			return mav;
		}
	
}
