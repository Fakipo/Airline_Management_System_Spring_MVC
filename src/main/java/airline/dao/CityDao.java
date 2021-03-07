package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public List<String> listCity()
	{
		String sql = "select airportcity from airport";
		List<String> stringList = new ArrayList<>();
		stringList = jdbcTemplate.queryForList(sql, String.class);
		for(String s: stringList)
		{
			System.out.println(s);
		}
		return stringList;
	}
	
		
}


