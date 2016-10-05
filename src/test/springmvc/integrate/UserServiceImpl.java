package test.springmvc.integrate;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		System.out.println("class is UserServiceImpl");
	}
	
	@Override
	public List<UserEntity> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(UserEntity ue) {
		
		System.out.println("save");
		System.out.println(ue.toString());
	}

	
}
