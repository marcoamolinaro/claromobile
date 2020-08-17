package br.molinaro.hitss.mobileclaro.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "mobile")
public class Mobile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", updatable = false, unique = true, nullable = false)
	private UUID code;
	
	private String model;
	
	private Integer price;
	
	private String brand;
	
	private String photo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String date;

	public Mobile() {
		super();
	}

	public Mobile(UUID code, String model, Integer price, String brand, String photo, String date) {
		super();
		this.code = code;
		this.model = model;
		this.price = price;
		this.brand = brand;
		this.photo = photo;
		this.date = date;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mobile [code=" + code + ", model=" + model + ", price=" + price + ", brand=" + brand + ", photo="
				+ photo + ", date=" + date + "]";
	}
}
