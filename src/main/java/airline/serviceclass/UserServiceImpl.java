package airline.serviceclass;
import org.springframework.beans.factory.annotation.Autowired;

import airline.dao.UserDao;
import airline.model.LoginBean;
import airline.model.UserBean;

public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;

	  public int register(UserBean userBean) {
	    return userDao.register(userBean);
	  }

	  public UserBean validateUser(LoginBean loginBean) {
	    return userDao.validateUser(loginBean);
	  }

	}