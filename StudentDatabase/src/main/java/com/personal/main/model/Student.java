package com.personal.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="ID")
	   private long id;
	   
	   @Column(name = "studentId")
	   private String studentId;
	   
	   @Column(name = "midtermGrade")
	   private Integer midtermGrade;
	   
	   @Column(name = "labGrade")
	   private Integer labGrade;
	   
	   @Column(name = "finalGrade")
	   private Integer finalGrade;
	   
	   @Column(name = "Average")
	   private Double avg;
	   
	   
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Integer getMidtermGrade() {
		return midtermGrade;
	}
	public void setMidtermGrade(Integer midtermGrade) {
		this.midtermGrade = midtermGrade;
	}
	public Integer getLabGrade() {
		return labGrade;
	}
	public void setLabGrade(Integer labGrade) {
		this.labGrade = labGrade;
	}
	public Integer getFinalGraded() {
		return finalGrade;
	}
	public void setFinalGraded(Integer finalGraded) {
		this.finalGrade = finalGraded;
	}

	   
	   
}
