package airline.model;

public class UserBean {
	  
	  private Long userid;
	  private String password;
	  private String fullName;
	  private String email;
	  private String mobile;
	  private String country;
	  private String type = "user";

	  		
	  public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public String getFullName() {
	  return fullName;
	  }
	  public void setFullName(String fullName) {
	  this.fullName = fullName;
	  }

	  public String getEmail() {
	  return email;
	  }
	  public void setEmail(String email) {
	  this.email = email;
	  }
	}