package com.demo.model;

/**
 * CoInfo entity. @author MyEclipse Persistence Tools
 */

public class CoInfo implements java.io.Serializable {

	// Fields

	private String memberNumber;
	private Integer vipPay;

	// Constructors

	/** default constructor */
	public CoInfo() {
	}

	/** minimal constructor */
	public CoInfo(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	/** full constructor */
	public CoInfo(String memberNumber, Integer vipPay) {
		this.memberNumber = memberNumber;
		this.vipPay = vipPay;
	}

	// Property accessors

	public String getMemberNumber() {
		return this.memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public Integer getVipPay() {
		return this.vipPay;
	}

	public void setVipPay(Integer vipPay) {
		this.vipPay = vipPay;
	}

}