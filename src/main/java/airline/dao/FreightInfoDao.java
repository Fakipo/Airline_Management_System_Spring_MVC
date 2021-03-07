package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import airline.model.FreightInfoBean;
import airline.model.InvoiceBean;

@Repository
public class FreightInfoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int createFreight(FreightInfoBean freightInfoBean) {
		String sql = "insert into cargo(recepientname,recepientemail,cargosizelarge,"
				+ "sendername,recepientmobile,recepientaddress,sendermobile,cargodate,fromairportid,toairportid,userid) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		return jdbcTemplate.update(sql, new Object[] {freightInfoBean.getRecepientName(),
				freightInfoBean.getRecepientEmail(),freightInfoBean.getCargosizeLarge(),
				freightInfoBean.getSenderName(),freightInfoBean.getRecepientMobile(),
				freightInfoBean.getRecepientAddress(),freightInfoBean.getSenderMobile(),
				freightInfoBean.getBookingDate(),freightInfoBean.getFromId(),freightInfoBean.getDestId(),freightInfoBean.getUserid()});
	}
	
	public FreightInfoBean getAirportId(String from, String destination)
	{
		List<FreightInfoBean> airportIdList = new ArrayList<>();
		airportIdList = jdbcTemplate.query ("select id, (select id from airport where airportcity = '"+destination+"' ) as destid "
				+ "from airport where airportcity = '"+ from +"'", new AirportIdMapper());
		
		
		return airportIdList.get(0);
	}

	private class AirportIdMapper implements RowMapper<FreightInfoBean> {
		public FreightInfoBean mapRow(ResultSet rs, int arg1) throws SQLException {
			FreightInfoBean freightInfoBean = new FreightInfoBean();
			freightInfoBean.setFromId(rs.getLong("id"));
			freightInfoBean.setDestId(rs.getLong("destid"));
			return freightInfoBean;
		}
	}
}
