package airline.serviceclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airline.dao.PassengerDao;
import airline.dao.ShopDao;
import airline.model.FlightBean;
import airline.model.PassengerBean;
import airline.model.ShopBean;

@Service
public class BookingHandler {
	
	@Autowired
	PassengerDao passengerDao;
	@Autowired
	ShopDao shopDao;

	
	public boolean createPassenger(PassengerBean passengerBean)
	{
		if(passengerDao.createPassenger(passengerBean) != 0 )
			return true;
		return false;
		
	}
	
	public boolean PassengerCheck(FlightBean flightBean)
	{
		int noOfPassengers = passengerDao.countPassengers(flightBean.getFlightId());
		if(flightBean.getAeroplaneBean().getNoofSeats()>(flightBean.getNoOfPassangers()+noOfPassengers))
			return true;
		return false;
	}
	
	public PassengerBean setPassenger(String first, String last, String passportNo, String email,String mobile,String address, long flightId) 
	{
		PassengerBean passengerBean = new PassengerBean();
		passengerBean.setFirst(first);
		passengerBean.setLast(last);
		passengerBean.setPassportNo(passportNo);
		passengerBean.setEmail(email);
		passengerBean.setMobile(mobile);
		passengerBean.setAddress(address);
		passengerBean.setFlightId(flightId);
		return passengerBean;
	}
	
	public long getPassengerId(String email)
	{
		return passengerDao.getPassengerId(email);
	}
	
	public void createShopItem(long passengerId, String itemName, int noOfItems, int itemPrice)
	{
		ShopBean shopBean = new ShopBean();
		shopBean.setItemName(itemName);
		shopBean.setPassengerId(passengerId);
		shopBean.setItemPrice(itemPrice);
		shopBean.setNoOfItems(noOfItems);
		shopDao.createShopItem(shopBean);
	}
}
