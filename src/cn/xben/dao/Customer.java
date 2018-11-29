package cn.xben.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	// 该类为crm Customer顾客类,包含信息如下：编号，姓名，性别，出生日期，电话，手机，级别，来源，行业

	private Long cust_id;
	private String cust_name;
	private String cust_gender;
	private String cust_born;
	private String cust_phone;
	private String cust_mobile;
//	private String cust_level;
//	private String cust_source;
//	private String cust_industry;
	
	private BaseDict cust_level;//cust_level.dict_id
	private BaseDict cust_source;
	private BaseDict cust_industry;

	// Customer与shopping表示一对多关系 用HashSet存储shopping对象

	private Set<Shopping> shoppings = new HashSet<Shopping>();

	public Set<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(Set<Shopping> shoppings) {
		this.shoppings = shoppings;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public String getCust_born() {
		return cust_born;
	}

	public void setCust_born(String cust_born) {
		this.cust_born = cust_born;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public BaseDict getCust_level() {
		return cust_level;
	}

	public void setCust_level(BaseDict cust_level) {
		this.cust_level = cust_level;
	}

	public BaseDict getCust_source() {
		return cust_source;
	}

	public void setCust_source(BaseDict cust_source) {
		this.cust_source = cust_source;
	}

	public BaseDict getCust_industry() {
		return cust_industry;
	}

	public void setCust_industry(BaseDict cust_industry) {
		this.cust_industry = cust_industry;
	}

	

}
