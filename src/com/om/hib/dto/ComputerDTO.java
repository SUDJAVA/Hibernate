package com.om.hib.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "com_table")
public class ComputerDTO implements Serializable {
	@Id
	@SequenceGenerator(name = "ref", sequenceName = "seq1", allocationSize = 1)
	@GeneratedValue(generator = "ref")
	@Column(name = "c_id")
	private int cid;
	@Column(name = "c_brand")
	private String brand;
	@Column(name = "c_color")
	private String color;
	@Column(name = "c_type")
	private String type;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private OSDTO osdto;

	public ComputerDTO() {
		System.out.println(this.getClass().getSimpleName() +" created");
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public OSDTO getOsdto() {
		return osdto;
	}

	public void setOsdto(OSDTO osdto) {
		this.osdto = osdto;
	}
}
