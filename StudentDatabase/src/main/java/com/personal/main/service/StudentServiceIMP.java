package com.personal.main.service;

public class StudentServiceIMP implements StudentService{

	@Override
	public double GradeAverage(int midterm, int lab, int fnal) {
		
		return 	 (midterm * 0.35) + (lab * 0.25) + (fnal * 0.40);
	
	}
	

}
