package org.sc.bean;

public class UserCount {
	public UserCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String gender;
	private String count;
	//select gender,count(*) from tb_users group by gender
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	//无参数构造public ，提供get set 封装业务逻辑类DAO登录逻辑， 分装数据处理数据；
	public UserCount(String gender, String count) {
		super();
		this.gender = gender;
		this.count = count;
	}
	

}
 