package test.springmvc.integrate;

import java.util.List;

public interface UserService {

	
	public List<UserEntity> findList();
	
	public void saveUser(UserEntity ue);
}
