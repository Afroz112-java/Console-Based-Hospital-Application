package com.HospitalApplication;

import java.util.Scanner;

public class HospitalApplication {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        System.out.println("🏥 Welcome to the Hospital Management System!");

        while (true) {
            System.out.println("\n====== Hospital Menu ======");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Disease");
            System.out.println("3. Update Doctor Assigned");
            System.out.println("4. View Patient Details");
            System.out.println("5. Remove Patient");
            System.out.println("6. Show All Patients");
            System.out.println("7. Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Enter patient name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter disease: ");
                        String disease = sc.nextLine();
                        System.out.print("Enter doctor assigned: ");
                        String doctor = sc.nextLine();
                        Patient p = hospital.addPatient(name, age, disease, doctor);
                        System.out.println("✅ Patient added. ID: " + p.getPatientId());
                        break;

                    case 2:
                        System.out.print("Enter patient ID: ");
                        int idD = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new disease: ");
                        String newDisease = sc.nextLine();
                        hospital.updateDisease(idD, newDisease);
                        System.out.println("🩺 Disease updated.");
                        break;

                    case 3:
                        System.out.print("Enter patient ID: ");
                        int idDoc = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new doctor: ");
                        String newDoctor = sc.nextLine();
                        hospital.updateDoctor(idDoc, newDoctor);
                        System.out.println("👨‍⚕ Doctor updated.");
                        break;

                    case 4:
                        System.out.print("Enter patient ID: ");
                        int idV = sc.nextInt();
                        Patient pv = hospital.getPatient(idV);
                        System.out.println(pv);
                        pv.showHistory();
                        break;

                    case 5:
                        System.out.print("Enter patient ID: ");
                        int idR = sc.nextInt();
                        hospital.removePatient(idR);
                        System.out.println("🗑 Patient removed.");
                        break;

                    case 6:
                        hospital.showAllPatients();
                        break;

                    case 7:
                        System.out.println("🙏 Thank you for using the Hospital Management System.");
                        sc.close();
                        return;

                    default:
                        System.out.println("⚠ Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }
}
