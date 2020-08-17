package br.molinaro.hitss.mobileclaro.dto;

import java.io.Serializable;
import java.util.UUID;

import br.molinaro.hitss.mobileclaro.domain.Mobile;

public class MobileDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID code;
	
	private String model;
	
	private Integer price;
	
	private String brand;
	
	private String photo;
	
	private String date;

	public MobileDTO() {
		super();
	}

	public MobileDTO(Mobile mobile) {
		super();
		this.code = mobile.getCode();
		this.model = mobile.getModel();
		this.price = mobile.getPrice();
		this.brand = mobile.getBrand();
		this.photo = mobile.getPhoto();
		this.date = mobile.getDate();
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
}
