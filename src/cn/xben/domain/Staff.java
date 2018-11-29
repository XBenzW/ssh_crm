package cn.xben.domain;

public class Staff {
	// 该类为crm staff员工类,包含信息如下：编号，姓名，性别，出生日期，密码，电话，手机

	private Long staff_id;
	private String staff_name;
	private String staff_gender;
	private String staff_born;
	private String staff_password;
	private String staff_phone;
	private String staff_mobile;

	public Long getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_gender() {
		return staff_gender;
	}

	public void setStaff_gender(String staff_gender) {
		this.staff_gender = staff_gender;
	}

	public String getStaff_born() {
		return staff_born;
	}

	public void setStaff_born(String staff_born) {
		this.staff_born = staff_born;
	}

	public String getStaff_password() {
		return staff_password;
	}

	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_mobile() {
		return staff_mobile;
	}

	public void setStaff_mobile(String staff_mobile) {
		this.staff_mobile = staff_mobile;
	}

}
