package airline.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EditTicketDao {

	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	public void cancelTickets(String email, Long flightid) {
		jdbcTemplate.execute("delete from passenger where email = '"+email+"' and flightid = "+flightid);
	}
}
