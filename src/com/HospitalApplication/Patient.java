package com.HospitalApplication;

import java.util.ArrayList;
import java.util.List;


public class Patient {
	 private int patientId;
	    private String name;
	    private int age;
	    private String disease;
	    private String doctorAssigned;
	    private List<String> history;

	    public Patient(int patientId, String name, int age, String disease, String doctorAssigned) throws InvalidInputException {
	        if (age <= 0) throw new InvalidInputException("Age must be greater than 0.");
	        if (name == null || name.trim().isEmpty()) throw new InvalidInputException("Name cannot be empty.");
	        this.patientId = patientId;
	        this.name = name;
	        this.age = age;
	        this.disease = disease;
	        this.doctorAssigned = doctorAssigned;
	        this.history = new ArrayList<>();
	        history.add("Patient record created.");
	    }

	    public int getPatientId() { return patientId; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public String getDisease() { return disease; }
	    public String getDoctorAssigned() { return doctorAssigned; }

	    public void updateDisease(String newDisease) {
	        this.disease = newDisease;
	        history.add("Disease updated to: " + newDisease);
	    }

	    public void updateDoctor(String newDoctor) {
	        this.doctorAssigned = newDoctor;
	        history.add("Doctor assigned: " + newDoctor);
	    }

	    public void showHistory() {
	        System.out.println("\n📜 History for Patient " + patientId + " (" + name + "):");
	        for (String h : history) {
	            System.out.println(" - " + h);
	        }
	    }

	    @Override
	    public String toString() {
	        return "Patient{" +
	                "ID=" + patientId +
	                ", Name='" + name + '\'' +
	                ", Age=" + age +
	                ", Disease='" + disease + '\'' +
	                ", Doctor='" + doctorAssigned + '\'' +
	                '}';
	    }
	}
