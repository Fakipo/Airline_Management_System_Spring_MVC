package airline.model;

public class FreightInfoBean {
	private String recepientName;
	private String recepientEmail;
	private Boolean cargosizeLarge;
	private String senderName;
	private String recepientMobile;
	private String recepientAddress;
	private String senderMobile;
	private Long fromId;
	private Long destId;
	private String bookingDate;
	private Long userid;
	
	
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getFromId() {
		return fromId;
	}
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getDestId() {
		return destId;
	}
	public void setDestId(Long destId) {
		this.destId = destId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getRecepientName() {
		return recepientName;
	}
	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}
	public String getRecepientEmail() {
		return recepientEmail;
	}
	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}
	
	public Boolean getCargosizeLarge() {
		return cargosizeLarge;
	}
	public void setCargosizeLarge(Boolean cargosizeLarge) {
		this.cargosizeLarge = cargosizeLarge;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecepientMobile() {
		return recepientMobile;
	}
	public void setRecepientMobile(String recepientMobile) {
		this.recepientMobile = recepientMobile;
	}
	public String getRecepientAddress() {
		return recepientAddress;
	}
	public void setRecepientAddress(String recepientAddress) {
		this.recepientAddress = recepientAddress;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	
	
	

}
