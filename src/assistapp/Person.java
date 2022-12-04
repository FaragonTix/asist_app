package assistapp;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Person {
	String name;
	String sname;
	String lang;
	String gender;
	LocalDate createdate;
	int birthday;
	int birthmonth;
	int birthyear;
	//static int counter;
	int id;
	//static{
		//counter = 0; }
	Person() { this.id=mainq.getRandomNumber(0,1000000000); this.createdate= LocalDate.now();}
	Person(String name, String sname, String lang, String gender, int birthday, int birthmonth, int birthyear){
		this.name=name;
		this.sname=sname;
		this.lang=lang;
		this.birthday=birthday;
		this.birthmonth=birthmonth;
		this.birthyear=birthyear;
		this.createdate= LocalDate.now();
		this.id=mainq.getRandomNumber(0,1000000000);
		this.gender=gender;
	
	}
	Person(String name, String sname, String lang, String gender, int birthday, int birthmonth, int birthyear, int id){
		this.name=name;
		this.sname=sname;
		this.lang=lang;
		this.birthday=birthday;
		this.birthmonth=birthmonth;
		this.birthyear=birthyear;
		this.createdate= LocalDate.now();
		this.id=id;
		this.gender=gender;
	
	}
	
	public int GetAge() {
		LocalDate today = LocalDate.now();
		return today.getYear()-this.birthyear;}
	public String GetWhole() {
		String s = this.gender+this.birthday+this.birthmonth+this.birthyear+this.GetAge()+this.name+this.sname+this.lang;
		return s.toLowerCase();
	}
	public void setId() {
		this.id=mainq.getRandomNumber(0,1000000000);
	}
	@Override
	public String toString() {
	return "Person: " + this.name + " " + this.sname;}
	
	public String getFullname() {
	return this.name+" "+this.sname;}
	}
	

