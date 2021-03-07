package airline.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import airline.model.InvoiceBean;

@Repository
public class InvoiceDao {
@Autowired
JdbcTemplate jdbcTemplate;

public InvoiceBean listInvoice(long passengerId,long flightId) {
	   Date flightTakeOff = jdbcTemplate.queryForObject("select arrivaldatetime from flight where id = "+flightId+"", Date.class);
	   
	   List<InvoiceBean> invoiceBeanList = jdbcTemplate.query("select seatno, email from passenger where id = "+passengerId+"",new InvoiceMapper());
	   invoiceBeanList.get(0).setFlighttime(flightTakeOff);
	   return invoiceBeanList.get(0);
}	


		private class InvoiceMapper implements RowMapper<InvoiceBean> {
				public InvoiceBean mapRow(ResultSet rs, int arg1) throws SQLException {
						InvoiceBean invoiceBean = new InvoiceBean();
						invoiceBean.setEmail(rs.getString("email"));
						invoiceBean.setSeatno(rs.getInt("seatno"));
						return invoiceBean;
				}
		}
}