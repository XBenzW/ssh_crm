package cn.xben.domain;

public class Admin {
	// 该类为crm admin管理员类，包含信息如下：编号，姓名，密码，电话，手机

	private Long adm_id;
	private String adm_name;
	private String adm_phone;
	private String adm_mobile;
	private String adm_password;

	public Long getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(Long adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}

	public String getAdm_phone() {
		return adm_phone;
	}

	public void setAdm_phone(String adm_phone) {
		this.adm_phone = adm_phone;
	}

	public String getAdm_mobile() {
		return adm_mobile;
	}

	public void setAdm_mobile(String adm_mobile) {
		this.adm_mobile = adm_mobile;
	}

	public String getAdm_password() {
		return adm_password;
	}

	public void setAdm_password(String adm_password) {
		this.adm_password = adm_password;
	}

	@Override
	public String toString() {
		return "Admin [adm_id=" + adm_id + ", adm_name=" + adm_name + ", adm_phone=" + adm_phone + ", adm_mobile="
				+ adm_mobile + ", adm_password=" + adm_password + "]";
	}

	
}
