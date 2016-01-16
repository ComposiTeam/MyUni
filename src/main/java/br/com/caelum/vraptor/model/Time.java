package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Time {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String day;
	
	private String begin;
	
	private String end;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public static Time getTime(String convert){
		convert = convert.replaceAll("\\W{2}", " ");
		System.out.println(convert);
		String[] pieces = convert.split(" ");
		System.out.println(pieces.length);
		Time time = new Time();
		time.setDay(pieces[0]);
		time.setBegin(pieces[1]);
		time.setEnd(pieces[3]);
		return time;
	}
	
	
}
