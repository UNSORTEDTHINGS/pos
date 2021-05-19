package zzxzxzxzxzxzx;

import java.io.File;

public class Patent {
	
	String name;
	int number;
	int age;
	Gender gender;
	File record;
	public Patent(String name, int number, int age, Gender gender, File record) {
		super();
		this.name = name;
		this.number = number;
		this.age = age;
		this.gender = gender;
		this.record = record;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public File getRecord() {
		return record;
	}
	public void setRecord(File record) {
		this.record = record;
	}
	
	

}
