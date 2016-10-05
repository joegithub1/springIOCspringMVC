package test.springmvc.integrate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserEntity {

	private Integer id;
	@NotEmpty(message="姓名不能为空")
	private String name;
	@Past(message="出生日期是个过去式")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	public UserEntity(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return "[id="+id+",name="+name+",birthday="+sdf.format(birthday)+"]";
	}
}
