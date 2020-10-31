package com.ndp.model;

public class MajorsModel extends AbstractModel<MajorsModel>{

	private long majors_code;
	private String majors_name;
	
	
	public long getMajors_code() {
		return majors_code;
	}
	public void setMajors_code(long majors_code) {
		this.majors_code = majors_code;
	}
	public String getMajors_name() {
		return majors_name;
	}
	public void setMajors_name(String majors_name) {
		this.majors_name = majors_name;
	}
	
}
