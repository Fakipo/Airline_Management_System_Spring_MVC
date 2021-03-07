package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import airline.model.PassengerBean;
import airline.model.UserBean;

@Repository
public class PassengerDao {
	
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	
	public int createPassenger(PassengerBean passengerBean)
	{
		Map<String,String> param = new HashMap<>();
		int seatno = jdbcTemplate.queryForObject("select count(id) as totseats from passenger where flightid = "+passengerBean.getFlightId() +"", Integer.class);
		String sql = "insert into passenger(address,email,first,last,mobile,passportno,flightid,seatno)"
				+ " values (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { passengerBean.getAddress(), passengerBean.getEmail(),
				passengerBean.getFirst(),passengerBean.getLast(),passengerBean.getMobile(),
				passengerBean.getPassportNo(),passengerBean.getFlightId(),(seatno+1) });
	}
	
	public List<PassengerBean> listPassenger()
	{
		Map<String,String> param = new HashMap<>();
		String sql = "select * from passenger";
		return jdbcTemplate.query(sql, new PassengerMapper());
	}
	
	 private class PassengerMapper implements RowMapper<PassengerBean> {
		  public PassengerBean mapRow(ResultSet rs, int arg1) throws SQLException {
		    PassengerBean passengerBean = new PassengerBean();

		    passengerBean.setAddress(rs.getString("address"));
		    passengerBean.setEmail(rs.getString("email"));
		    passengerBean.setFirst(rs.getString("first"));
		    passengerBean.setLast(rs.getString("last"));
		    passengerBean.setMobile(rs.getString("mobile"));
		    passengerBean.setPassportNo(rs.getString("passportno"));
		    passengerBean.setFlightId(rs.getLong("flightid"));
		    passengerBean.setSeatno(rs.getInt("seatno"));
		    return passengerBean;
		
		  }
	 }
	 
	 public int countPassengers(long flightId) {
		return jdbcTemplate.queryForObject("select count(id) as noOfPassengers from passenger where "
		 		+ "flightid = "+flightId+" ", Integer.class);
	 }
	 
	 public long getPassengerId(String email)
	 {
		 return jdbcTemplate.queryForObject("select id from passenger where email = '"+email+"' limit 1",Long.class);
	 }
	
}
