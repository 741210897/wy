package com.demo.model;

/**
 * MeInfo entity. @author MyEclipse Persistence Tools
 */

public class MeInfo implements java.io.Serializable {

	// Fields

	private String memberNumber;
	private String memberPassword;
	private String memberName;
	private String memberPhoneNumber;
	private Integer memberCost;
	private String vipNum;

	// Constructors

	/** default constructor */
	public MeInfo() {
	}

	/** minimal constructor */
	public MeInfo(String memberNumber, String memberPassword,
			String memberName, String memberPhoneNumber, String vipNum) {
		this.memberNumber = memberNumber;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.vipNum = vipNum;
	}

	/** full constructor */
	public MeInfo(String memberNumber, String memberPassword,
			String memberName, String memberPhoneNumber, Integer memberCost,
			String vipNum) {
		this.memberNumber = memberNumber;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberCost = memberCost;
		this.vipNum = vipNum;
	}

	// Property accessors

	public String getMemberNumber() {
		return this.memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return this.memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public Integer getMemberCost() {
		return this.memberCost;
	}

	public void setMemberCost(Integer memberCost) {
		this.memberCost = memberCost;
	}

	public String getVipNum() {
		return this.vipNum;
	}

	public void setVipNum(String vipNum) {
		this.vipNum = vipNum;
	}

}