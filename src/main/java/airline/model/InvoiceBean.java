package airline.model;

import java.util.Date;

public class InvoiceBean {
	
	private String email;
	private Date flighttime;
	private int seatno;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFlighttime() {
		return flighttime;
	}
	public void setFlighttime(Date flighttime) {
		this.flighttime = flighttime;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	
	

}
