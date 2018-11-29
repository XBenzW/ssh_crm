package cn.xben.domain;

public class Shopping {
	// 该类为crm shopping 订单类,包含信息如下：编号，日期，消费项目，消费产品，消费价格，签字

	private Long shop_id;
	private String shop_date;
	private String shop_project;
	private String shop_product;
	private String shop_price;
	private boolean shop_confirm;

	// 为shopping配置多对一关系
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_date() {
		return shop_date;
	}

	public void setShop_date(String shop_date) {
		this.shop_date = shop_date;
	}

	public String getShop_project() {
		return shop_project;
	}

	public void setShop_project(String shop_project) {
		this.shop_project = shop_project;
	}

	public String getShop_product() {
		return shop_product;
	}

	public void setShop_product(String shop_product) {
		this.shop_product = shop_product;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	public boolean isShop_confirm() {
		return shop_confirm;
	}

	public void setShop_confirm(boolean shop_confirm) {
		this.shop_confirm = shop_confirm;
	}

}
