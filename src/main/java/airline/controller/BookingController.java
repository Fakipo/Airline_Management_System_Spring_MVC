package airline.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import airline.dao.CityDao;
import airline.dao.FlightDao;
import airline.dao.InvoiceDao;
import airline.dao.PassengerDao;
import airline.model.FlightBean;
import airline.model.InvoiceBean;
import airline.model.PassengerBean;
import airline.serviceclass.BookingHandler;

@Controller
public class BookingController {
	
	
	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	BookingHandler bookingHandler;
	
	@Autowired
	FlightDao flightDao;
	
	@Autowired
	CityDao cityDao;
	@Autowired
	InvoiceDao invoiceDao;
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String showHomePage() {
		return "booking";
	}
	
	
	@RequestMapping(value = "/viewScheduleInitial", method = RequestMethod.GET)
	public ModelAndView viewScheduleInitial( String from, String destination,  
			String flightDate) throws ParseException
	{
		ModelAndView mav = new ModelAndView();
		
		List<String> l1 = new ArrayList<>();
		List<String> cityList = cityDao.listCity();
		l1 = cityList;
		mav.addObject("cityNameList", l1);
		mav.setViewName("schedulesearchflights");
		System.out.println("in booking controller"+cityList);
		return mav;
	}
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView viewSchedule( String from, String destination,  
			String flightDate) throws ParseException
	{
		ModelAndView mav = new ModelAndView();
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(flightDate);
		System.out.println("hello we are here");
		System.out.println(from + destination + flightDate);
		mav.setViewName("scheduleresult");
		String errorHandler = null;
		try {		
		List<FlightBean> flightBeanList = flightDao.listFlights(from,destination,flightDate);
		mav.addObject("flightBeanList", flightBeanList);
		}
		catch(Exception e) {
			errorHandler = "Some error has occured, please try again later.";
		}
		mav.addObject("errorHandler",errorHandler);
		return mav;
	}
	
	
	@RequestMapping(value = "/searchFlights", method = RequestMethod.GET)
	public ModelAndView searchFlights( String from, String destination,  
			String flightDate) throws ParseException
	{
		ModelAndView mav = new ModelAndView();
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(flightDate);
		System.out.println("hello we are here");
		System.out.println(from + destination + flightDate);
		mav.setViewName("searchresults");
		String errorHandler = null;
		try {
		List<FlightBean> flightBeanList = flightDao.listFlights(from,destination,flightDate);
		mav.addObject("flightBeanList", flightBeanList);
		}
		catch(Exception e) {
			errorHandler = "Some error has occured, please try again later.";
		}
		mav.addObject("errorHandler",errorHandler);
		return mav;
	}
	
	@RequestMapping(value = "/searchFlightsInitial", method = RequestMethod.GET)
	public ModelAndView flightsInitiate()
	{
		ModelAndView mav = new ModelAndView();
		
		List<String> l1 = new ArrayList<>();
		List<String> cityList = cityDao.listCity();
		l1 = cityList;
		mav.addObject("cityNameList", l1);
		mav.setViewName("searchflights");
		System.out.println("in booking controller"+cityList);
		return mav;
	}
	
	@RequestMapping(value = "/checkPassengersInitial", method = RequestMethod.GET)
	public ModelAndView checkPassengersInitial(@RequestParam int flightCharge,
			long flightId, int noOfSeats, String destAirportName, String fromAirportName,
			long aeroplaneId, int noOfPassengers) 
	{
		
		FlightBean flightBean = flightDao.setValues(flightCharge,flightId,noOfSeats,destAirportName,fromAirportName,aeroplaneId,noOfPassengers);
		ModelAndView mav = new ModelAndView();
		System.out.println(flightCharge);
		System.out.println(noOfSeats);
		System.out.println(destAirportName);
		System.out.println(fromAirportName);
		System.out.println(aeroplaneId);
		System.out.println(flightId);
		System.out.println(noOfPassengers);
		
		mav.addObject("flightbean",flightBean);
		mav.addObject("isSeatAvailable",bookingHandler.PassengerCheck(flightBean));
		mav.addObject("noOfPassengers",noOfPassengers);
		mav.setViewName("passengerDetails");
		
		return mav;
	}
	
	@RequestMapping(value = "/createPassenger", method = RequestMethod.GET)
	public ModelAndView createPassanger(String firstnamebooker, String firstname1, String firstname2,String firstname3, String firstname4,
			String lastnamebooker, String lastname1, String lastname2, String lastname3,
			String passportbooker, String passport1, String passport2, String passport3,
			String email, String mobile, String address, long flightid,
			
			int flightCharge,
			long flightId, int noOfSeats, String destAirportName, String fromAirportName,
			long aeroplaneId, int noOfPassengers
			)
	{
		
		FlightBean flightBean = flightDao.setValues(flightCharge,flightId,noOfSeats,destAirportName,fromAirportName,aeroplaneId,noOfPassengers);

		PassengerBean passengerBeanBooker = bookingHandler.setPassenger(firstnamebooker,lastnamebooker,passportbooker,email,mobile,address,flightid);
		bookingHandler.createPassenger(passengerBeanBooker);
		if(firstname1 != null)
		{
			if(!firstname1.equals(""))
			{
				PassengerBean passengerBean = bookingHandler.setPassenger(firstname1,lastname1,passport1,null,mobile,address,flightid);
				bookingHandler.createPassenger(passengerBean);
			}
		}
		if(firstname2 != null)
		{
			if(!firstname2.equals(""))
			{
				PassengerBean passengerBean = bookingHandler.setPassenger(firstname2,lastname2,passport2,null,mobile,address,flightid);
				bookingHandler.createPassenger(passengerBean);
			}
		}
		if(firstname3 != null)
		{
			if(!firstname3.equals(""))
			{
				PassengerBean passengerBean = bookingHandler.setPassenger(firstname3,lastname3,passport3,null,mobile,address,flightid);
				bookingHandler.createPassenger(passengerBean);
			}
		}
		//boolean isPassengerCreated = bookingHandler.createPassenger(passengerBean);
		ModelAndView mav = new ModelAndView();
		long passengerId = bookingHandler.getPassengerId(email);
		mav.setViewName("shop");
		mav.addObject("flightbean", flightBean);
		mav.addObject("passengerId",passengerId);
		mav.addObject("noOfPassengers",noOfPassengers);
		return mav;
	}
	
	@RequestMapping(value = "/listPassenger", method = RequestMethod.GET)
	public List<PassengerBean> listPassenger(@RequestBody PassengerBean passengerBean)
	{
		return passengerDao.listPassenger();
	}
	
	@RequestMapping(value = "/totalTicketInitial", method = RequestMethod.POST)
	public ModelAndView totalTicketInitial(@RequestParam int flightCharge,
			long flightId, int noOfSeats, String destAirportName, String fromAirportName,
			long aeroplaneId, int noOfPassengers, long passengerId, 
			
			int eyecoverno, int neckpillowno, int slippersno)
	{
		FlightBean flightBean = flightDao.setValues(flightCharge,flightId,noOfSeats,destAirportName,fromAirportName,aeroplaneId,noOfPassengers);
		int eyecoverprice = 0;
		int neckpillowprice = 0;
		int slipperprice = 0;
		if(eyecoverno > 0)
		{
			bookingHandler.createShopItem(passengerId, "eyecover", eyecoverno, 10);
			eyecoverprice = 10 * eyecoverno;
		}
		
		if(neckpillowno > 0)
		{
			bookingHandler.createShopItem(passengerId, "neckpillow", neckpillowno, 20);
			neckpillowprice = 20 * neckpillowno;
		}
		
		if(slippersno > 0)
		{
			bookingHandler.createShopItem(passengerId, "slippers", slippersno, 10);
			slipperprice = 10 * slippersno;
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("totalticket");
		mav.addObject("noOfPassengers",noOfPassengers);
		mav.addObject("passengerId",passengerId);
		mav.addObject("slipperprice", slipperprice);
		mav.addObject("eyecoverprice", eyecoverprice);
		mav.addObject("neckpillowprice", neckpillowprice);
		mav.addObject("flightprice", noOfPassengers *  flightCharge);
		mav.addObject("flightbean", flightBean);

		return mav;
	}
	
	@RequestMapping(value = "/invoiceInitial", method = RequestMethod.POST)
	public ModelAndView invoiceInitial(@RequestParam int flightCharge,
			long flightId, int noOfSeats, String destAirportName, String fromAirportName,
			long aeroplaneId, int noOfPassengers, long passengerId, 
			
			 int totalamount)
	{
		ModelAndView mav = new ModelAndView();
		InvoiceBean invoiceBean = invoiceDao.listInvoice(passengerId, flightId);
		int seatnoint = invoiceBean.getSeatno();
		String seatno = Integer.toString(seatnoint);
		for(int i = 1 ; i <= noOfPassengers ; i++)
		{
			seatno = seatno +","+ Integer.toString(seatnoint+i);
		}
		Date dateNow = new Date();
		mav.addObject("totalamount",totalamount);
		mav.addObject("toairport",destAirportName);
		mav.addObject("fromairport",fromAirportName);
		mav.addObject("bookingdate", dateNow);
		mav.addObject("email",invoiceBean.getEmail());
		mav.addObject("seatno",seatno);
		mav.addObject("flightId",flightId);
		mav.addObject("flighttime",invoiceBean.getFlighttime()); 	
		mav.setViewName("invoice");
		return mav;
		
	}
	
	
	@RequestMapping(value = "/theend", method = RequestMethod.GET	)
	public ModelAndView theend(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/Home2");
		return mav;
	}
	
}


