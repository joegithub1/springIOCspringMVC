package test.springmvc.integrate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
* @ClassName: UserControlle 
* @Description: TODO user控制器
* @author  huangjian
* @date 2016年10月5日 下午4:55:35 
*
 */
@Controller
@RequestMapping("/user")
public class UserControlle {

	//注入需要配置spirngIOC
	@Autowired
	private UserServiceImpl userServiceImpl;
	private Map<String, UserEntity> userMap=new HashMap<String,UserEntity>();
	private List<UserEntity> list=new ArrayList<UserEntity>();
	public UserControlle() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		userMap.put("zs", new UserEntity(1, "zhangsan", new Date()));
		userMap.put("ls", new UserEntity(2, "lisi", new Date()));
		
		list.add(new UserEntity(1, "zhangsan", sdf.parse("1999-0-1")));
		list.add(new UserEntity(2, "lisi", sdf.parse("1991-10-10")));
	}
	public void init(UserEntity ue){
		if(ue == null){
			
		}else{
			userMap.put(ue.getName(), ue);
		}
		
	}
	@RequestMapping("/list")
	public String getUserList(Map<String, Object> map){
		
		map.put("users", list);
		
		return "list";
	}
	/**
	 * 
	* @Title: saveUser 
	* @Description: 添加用户
	* @param @param user
	* @param @param br
	* @param @param model
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") UserEntity user,BindingResult br,Model model){
		//UserEntity ue=new UserEntity(1, "zhangsan", new Date());
		/**
		System.out.println("errorCount："+br.getErrorCount());
		System.out.println(""+br.getObjectName());
		System.out.println(""+br.getFieldError("birthday"));
		System.out.println(""+br.getFieldValue("birthday"));
		*/
		//userServiceImpl.saveUser(user);
		if(br.getErrorCount() >0){
			//注意不能重定向
			//return "redirect:toAdd.do";
			return "add";
		}
		user.setId(list.size()+1);
		list.add(user);
		return "redirect:list.do";
	}
	/**
	 *  
	* @Title: addPage 
	* @Description: 去添加页面
	* @param @param map
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPage(Map<String,UserEntity> map){
		  //因为在页面上有个modelAttribute="user" user对象，所以要传递一个空的过去，否则报错
		map.put("user", new UserEntity());
		return "add";
	}
	/**
	 * 
	* @Title: show 
	* @Description: 根据id条件查询
	* @param @param id
	* @param @param map
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping(value="/show/{id}.do",method=RequestMethod.GET)
	public String show(@PathVariable("id") Integer id,Map<String, UserEntity> map){
		UserEntity ue=list.get((id-1));
		map.put("user", ue);
		return "show";
	}
	/**
	 * 
	* @Title: delete 
	* @Description: 删除
	* @param @param id
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id){
		
		list.remove((id-1));
		
		return "redirect:/user/list.do";
	}
	/**
	 * 
	* @Title: update 
	* @Description: 去添加页面
	* @param @param id
	* @param @param map
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable("id") Integer id,Map<String, UserEntity> map){
		
		UserEntity ue= list.get((id-1));
		//modelAttribute="user" key与user一致
		map.put("user", ue);
		
		return "add";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable("id") Integer id,@Valid UserEntity user){
		
		UserEntity u=list.get((id-1));
		u.setName(user.getName());
		u.setBirthday(user.getBirthday());
		
		list.set((id-1), u);
		return "redirect:/user/list.do";
	}
}
