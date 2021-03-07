package airline.model;

import java.util.Date;

public class FlightBean {
	
	private long flightId;
	private int flightCharge;
	private long aeroplaneId;
	private Date arrivalDateTime;
	private Date departureDateTime;


	private AirportBean destinationAirport;
	private AirportBean fromAirport;
	private AeroplaneBean aeroplaneBean; 
	private long destAirportId;
	private long fromAirportId;

	
	private int noOfPassangers;
	
	
	
	public FlightBean() {
		aeroplaneBean =  new AeroplaneBean();
		destinationAirport = new AirportBean();
		fromAirport = new AirportBean();
	}
	
	
	
	public AirportBean getDestinationAirport() {
		return destinationAirport;
	}



	public void setDestinationAirport(AirportBean destinationAirport) {
		this.destinationAirport = destinationAirport;
	}



	public AirportBean getFromAirport() {
		return fromAirport;
	}



	public void setFromAirport(AirportBean fromAirport) {
		this.fromAirport = fromAirport;
	}



	public AeroplaneBean getAeroplaneBean() {
		return aeroplaneBean;
	}



	public void setAeroplaneBean(AeroplaneBean aeroplaneBean) {
		this.aeroplaneBean = aeroplaneBean;
	}



	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public int getFlightCharge() {
		return flightCharge;
	}
	public void setFlightCharge(int flightCharge) {
		this.flightCharge = flightCharge;
	}
	public long getAeroplaneId() {
		return aeroplaneId;
	}
	public void setAeroplaneId(long aeroplaneId) {
		this.aeroplaneId = aeroplaneId;
	}

	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public Date getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}


	public int getNoOfPassangers() {
		return noOfPassangers;
	}
	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	public long getDestAirportId() {
		return destAirportId;
	}
	public void setDestAirportId(long destAirportId) {
		this.destAirportId = destAirportId;
	}

	public long getFromAirportId() {
		return fromAirportId;
	}
	public void setFromAirportId(long fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	
	
}
