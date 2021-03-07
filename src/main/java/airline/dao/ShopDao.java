package airline.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airline.model.ShopBean;

@Repository
public class ShopDao {
	
@Autowired
JdbcTemplate jdbcTemplate;

public int createShopItem(ShopBean shopBean)
	{
	  String sql = "insert into shop(passengerid, itemname, noofitems,itemprice)"
				+ " values (?,?,?,?)";
	  return jdbcTemplate.update(sql, new Object[] {shopBean.getPassengerId(),shopBean.getItemName(),
			  shopBean.getNoOfItems(),shopBean.getItemPrice()});
	  
	}

}
