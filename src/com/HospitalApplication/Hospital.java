package com.HospitalApplication;

import java.util.HashMap;
import java.util.Map;


public class Hospital {
	private Map<Integer, Patient> patients = new HashMap<>();
    private static int patientCounter = 1;

    public Patient addPatient(String name, int age, String disease, String doctorAssigned) throws InvalidInputException {
        int id = patientCounter++;
        Patient p = new Patient(id, name, age, disease, doctorAssigned);
        patients.put(id, p);
        return p;
    }

    public Patient getPatient(int id) throws PatientNotFoundException {
        if (!patients.containsKey(id)) {
            throw new PatientNotFoundException("Patient " + id + " not found.");
        }
        return patients.get(id);
    }

    public void updateDisease(int id, String newDisease) throws PatientNotFoundException {
        getPatient(id).updateDisease(newDisease);
    }

    public void updateDoctor(int id, String newDoctor) throws PatientNotFoundException {
        getPatient(id).updateDoctor(newDoctor);
    }

    public void removePatient(int id) throws PatientNotFoundException {
        if (!patients.containsKey(id)) {
            throw new PatientNotFoundException("Patient " + id + " not found.");
        }
        patients.remove(id);
    }

    public void showAllPatients() {
        System.out.println("\n📋 List of Patients:");
        if (patients.isEmpty()) {
            System.out.println(" - No patients found.");
        } else {
            for (Patient p : patients.values()) {
                System.out.println(" - " + p);
            }
        }
    }
}
