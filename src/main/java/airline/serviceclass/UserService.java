package airline.serviceclass;

import airline.model.LoginBean;
import airline.model.UserBean;

public interface UserService {

	  int register(UserBean userBean);

	  UserBean validateUser(LoginBean loginBean);
	}