package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import airline.model.LoginBean;
import airline.model.UserBean;

@Repository
public class UserDao  {
	@Autowired
  	DataSource datasource;
  	@Autowired
  	JdbcTemplate jdbcTemplate;
  	
  	
  	
  	public int register(UserBean userBean) {
	 
    String sql = "insert into user(fullname,email,password,country,mobile,type) values(?,?,md5(?),?,?,?)";
    return jdbcTemplate.update(sql, new Object[] { userBean.getFullName(), userBean.getEmail(),  userBean.getPassword(), 
    		userBean.getCountry(),userBean.getMobile(),userBean.getType() });
    }
  
  
  	
  	
  	
    public UserBean validateUser(LoginBean loginBean) {
    	
    
    String sql = "select `fullname`,email,id from user where `email` ='" + loginBean.getemail() + "' and password= md5('" + loginBean.getPassword()
    + "')";
    List<UserBean> userBeans = new ArrayList<>();
    try {
    userBeans = jdbcTemplate.query(sql, new UserMapper());
    }
    catch(Exception e) {
    	System.out.println("errror duplicate for now");
    	
    }
    return userBeans.size() > 0 ? userBeans.get(0) : null;

    }
  	

  	private static final class UserMapper implements RowMapper<UserBean> {
  	    public UserBean mapRow(ResultSet rs, int arg1) throws SQLException {
  	    UserBean userBean = new UserBean();
  	    userBean.setFullName(rs.getString("fullname"));
  	    userBean.setEmail(rs.getString("email"));
  	    userBean.setUserid(rs.getLong("id"));
  	    
  	    System.out.print(userBean.getFullName());
  	    System.out.println(userBean.getEmail());
  	    return userBean;
  	  }
  	}

}





