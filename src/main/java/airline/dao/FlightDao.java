package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import airline.model.FlightBean;

@Repository
public class FlightDao {
	
	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	
	public List<FlightBean> listFlights(String from, String destination, 
			String flightDate)
	{
		String sql = "select  aero.*, flight.*, airport.airportcity, airport.airportname ,"
				+ " (select airportname from airport where airportcity = '"+ from +"') as fromairport, "
				+ " (select airportcity from airport where airportcity = '"+from+"') as fromcity "
						+ "from aeroplane aero, flight, airport where flight.aeroplaneid = aero.id and "
						+ "airport.id = flight.destairportid and airport.airportcity = '"+ destination+ "' "
								+" and flight.fromairportid = (select id from airport where airport.airportcity = '"+from+"' ) and flight.arrivaldatetime > '"+flightDate+"'";
		
		return jdbcTemplate.query(sql, new FlightMapper());

	}
	 private class FlightMapper implements RowMapper<FlightBean> {
		  public FlightBean mapRow(ResultSet rs, int arg1) throws SQLException {
			  FlightBean flightBean = new FlightBean();
			  
			  flightBean.setFlightId(rs.getLong("flight.id"));
			  flightBean.setFlightCharge(rs.getInt("flight.flightcharge"));
			  flightBean.setAeroplaneId(rs.getLong("flight.aeroplaneid"));
			  flightBean.setDestAirportId(rs.getLong("flight.destairportid"));
			  flightBean.setFromAirportId(rs.getLong("flight.fromairportid"));
			  flightBean.setArrivalDateTime(rs.getTimestamp("flight.arrivaldatetime"));
			  flightBean.setDepartureDateTime(rs.getTimestamp("flight.departuredatetime"));
			  flightBean.getAeroplaneBean().setNoofSeats(rs.getInt("aero.noofseats"));
			  flightBean.getAeroplaneBean().setAeroplaneId(rs.getLong("aero.id"));
			  flightBean.getAeroplaneBean().setCompany(rs.getString("aero.company"));
			  
			  
			  flightBean.getDestinationAirport().setAirportName(rs.getString("airport.airportname"));
			  flightBean.getDestinationAirport().setAirportCity(rs.getString("airport.airportcity"));
			  
			  flightBean.getFromAirport().setAirportName(rs.getString("fromairport"));
			  flightBean.getFromAirport().setAirportCity(rs.getString("fromcity"));
			  
			  System.out.println("here is the result" + flightBean);
		    return flightBean;
		
		  }
	 }
	 
	 public FlightBean setValues(int flightCharge,
				long flightId, int noOfSeats, String destAirportName, String fromAirportName,
				long aeroplaneId, int noOfPassengers) {
		 FlightBean flightBean = new FlightBean();
		 flightBean.setFlightCharge(flightCharge);
		 flightBean.setFlightId(flightId);
		 flightBean.getAeroplaneBean().setNoofSeats(noOfSeats);
		 flightBean.getDestinationAirport().setAirportName(destAirportName);
		 flightBean.getFromAirport().setAirportName(fromAirportName);
		 flightBean.setAeroplaneId(aeroplaneId);
		 flightBean.setNoOfPassangers(noOfPassengers);
		 return flightBean;
		 
	 }

}
