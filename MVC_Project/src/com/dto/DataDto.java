package com.dto;

public class DataDto {
	
	private String c_name;
	private int c_age;
	private String c_gender;
	private String c_ssn;
	private int c_no;
	private String c_dis;
	private String c_imp;
	private String c_date;
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_age() {
		return c_age;
	}
	public void setC_age(int c_age) {
		this.c_age = c_age;
	}
	public String getC_gender() {
		return c_gender;
	}
	public void setC_gender(String c_gender) {
		this.c_gender = c_gender;
	}
	public String getC_ssn() {
		return c_ssn;
	}
	public void setC_ssn(String c_ssn) {
		this.c_ssn = c_ssn;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_dis() {
		return c_dis;
	}
	public void setC_dis(String c_dis) {
		this.c_dis = c_dis;
	}
	public String getC_imp() {
		return c_imp;
	}
	public void setC_imp(String c_imp) {
		this.c_imp = c_imp;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	
	public String toString() {
		String str = "이름 : " + c_name + "\n"
				+ "나이 : " + c_age + "\n"
				+ "성별 : " + c_gender + "\n"
				+ "주민등록번호 : " + c_ssn + "\n"
				+ "차트번호 : " + c_no + "\n"
				+ "과거병력 : " + c_dis + "\n"
				+ "진료내용 : " + c_imp + "\n"
				+ "진료날짜 : " + c_date;
		return str;
	}
	
}	
	