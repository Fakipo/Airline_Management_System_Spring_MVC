package airline.model;

public class AeroplaneBean {

	private long aeroplaneId;
	private String company;
	private int noofSeats;
	
	
	public long getAeroplaneId() {
		return aeroplaneId;
	}
	public void setAeroplaneId(long aeroplaneId) {
		this.aeroplaneId = aeroplaneId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getNoofSeats() {
		return noofSeats;
	}
	public void setNoofSeats(int noofSeats) {
		this.noofSeats = noofSeats;
	}
}
