package domain;

import java.util.Date;

/*
 * 这是封装的对象bean ---写各种信息的get和set方法
 */
public class Student {
 
	private int sid;    //数据库里面拥有的所有属性
	private String sname; 
	private String gender;
	private String phone;
	private String hobby;
	private String info;
	private Date birthday;
	
	 
	//添加一个无参构造函数
  public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}

  
  public Student(int sid, String sname, String gender, String phone, String hobby, String info, Date birthday) {
		super();
		this.sid =sid;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
	}

	//直接一个方法把所有的调用 防止以后需要一个一个输入
	public Student(String sname, String gender, String phone, String hobby, String info, Date birthday) {  
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
	}
	

	//下面是所有的set和get方法
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
