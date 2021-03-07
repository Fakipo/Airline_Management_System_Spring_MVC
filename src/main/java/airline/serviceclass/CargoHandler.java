package airline.serviceclass;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airline.dao.FreightInfoDao;
import airline.model.FreightInfoBean;

@Service
public class CargoHandler {
	@Autowired
	FreightInfoDao freightInfoDao;
	public FreightInfoBean createFreight(String recepientName, String recepientEmail,
			String recepientMobile, String recepientAddress, String senderName,
			String senderMobile, Boolean cargoSize, String destination, String from, String flightDate,Long userid) {
			
			FreightInfoBean freightInfoBean2 = freightInfoDao.getAirportId(from,destination);
			Long fromId =freightInfoBean2.getFromId();
			Long destId =freightInfoBean2.getDestId();
			FreightInfoBean freightInfoBean = new FreightInfoBean();
			
			freightInfoBean.setRecepientName(recepientName);
			freightInfoBean.setRecepientEmail(recepientEmail);
			freightInfoBean.setRecepientMobile(recepientMobile);
			freightInfoBean.setRecepientAddress(recepientAddress);
			freightInfoBean.setSenderMobile(senderMobile);
			freightInfoBean.setSenderName(senderName);
			freightInfoBean.setCargosizeLarge(cargoSize);
			freightInfoBean.setDestId(destId);
			freightInfoBean.setFromId(fromId);
			freightInfoBean.setBookingDate(flightDate);
			freightInfoBean.setUserid(userid);
			return freightInfoBean;
			
		
	}
}
