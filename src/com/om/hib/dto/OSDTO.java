package com.om.hib.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "os_table")
public class OSDTO implements Serializable {
	@Id
	@SequenceGenerator(name = "ref", sequenceName = "seq2", allocationSize = 1)
	@GeneratedValue(generator = "ref")
	@Column(name = "o_id")
	private int oid;
	@Column(name = "o_version")
	private double version;
	@Column(name = "o_name")
	private String name;
	@Column(name = "o_bits")
	private int bits;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "comp")
	ComputerDTO comdto;

	public OSDTO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public ComputerDTO getComdto() {
		return comdto;
	}

	public void setComdto(ComputerDTO comdto) {
		this.comdto = comdto;
	}

}
