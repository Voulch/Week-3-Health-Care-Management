// Main class to run the program and process user input
package Healthcare;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation(scanner);

        LinkedList<Doctor> doctors = Doctor.createDoctors();
        LinkedList<Nurse> nurses = Nurse.createNurses();

        Patient patient = createPatient(validation);
        Doctor doctor = chooseDoctor(scanner, doctors, validation);
        Nurse nurse = chooseNurse(scanner, nurses, validation);
        MedicalLog log = createMedicalLog(patient, doctor, nurse, validation);
        patient.addLog(log);

        AppointManager appointmentManager = new AppointManager();
        AppointController appointmentController = new AppointController(appointmentManager, validation);
        manageAppointments(scanner, patient, doctor, nurse, appointmentController);

        patient.viewBilling();
    }


    private static Patient createPatient(Validation validation) {
        System.out.println("\n======== Enter Patient details ========\n");

        String name = validation.valString("Name: ");
        String patientId = validation.valString("Patient ID: ");
        String dateOfBirth = validation.valString("Date of Birth: ");
        String phoneNumber = validation.valString("Phone Number: ");

        System.out.println("\n=======================================");

        return new Patient(patientId, name, dateOfBirth, phoneNumber);
    }

    private static Doctor chooseDoctor(Scanner scanner, LinkedList<Doctor> doctors, Validation validation) {
        System.out.println("\n========== Available Doctors ==========");
        System.out.println();
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName() + " - " + doctors.get(i).getSpecialty());
        }
        System.out.print("\nWhich Doctor do you need?: ");
        int doctorChoice = validation.valInt(scanner, 1, doctors.size());
        System.out.println("\n=======================================");
        return doctors.get(doctorChoice - 1);
    }

    private static Nurse chooseNurse(Scanner scanner, LinkedList<Nurse> nurses, Validation validation) {
        System.out.println("\n========== Available Nurses ===========");
        System.out.println();
        for (int i = 0; i < nurses.size(); i++) {
            System.out.println((i + 1) + ". " + nurses.get(i).getName() + " - " + nurses.get(i).getDepartment());
        }
        System.out.print("\nWhich Nurse do you need?: ");
        int nurseChoice = validation.valInt(scanner, 1, nurses.size());
        System.out.println("\n=======================================");
        return nurses.get(nurseChoice - 1);
    }

    private static MedicalLog createMedicalLog(Patient patient, Doctor doctor, Nurse nurse, Validation validation) {
        System.out.println("\n====== Enter Medical log details ======");
        String logId = validation.valString("\nLog ID: ");
        System.out.println("\n=======================================");
        MedicalLog log = new MedicalLog(logId, patient, doctor);
        log.addStaff(nurse);
    
        System.out.println("\n=======================================");
        String response = validation.valYesNo("\nAdd prescription? (yes/no): ");
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("\n=======================================");
            String prescription = validation.valString("\nPrescription: ");
            log.addPrescription(prescription);
            System.out.println("\n=======================================");
        }
    
        System.out.println("\n=======================================");
        response = validation.valYesNo("\nAdd test result? (yes/no): ");
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("\n=======================================");
            String testResult = validation.valString("\nTest Result: ");
            log.addTestResult(testResult);
            System.out.println("\n=======================================");
        }
    
        return log;
    }

    private static void manageAppointments(Scanner scanner, Patient patient, Doctor doctor, Nurse nurse, AppointController appointmentController) {
        while (true) {
            System.out.println("\n======= Schedule an Appointment =======");
            System.out.println("\n1. Schedule an Appointment");
            System.out.println("2. Update an Appointment");
            System.out.println("3. Cancel an Appointment");
            System.out.println("4. Search an Appointment");
            System.out.println("5. Filter an Appointment");
            System.out.println("6. Exit");
            System.out.print("\nChoose an option: ");
            int choice = appointmentController.validation.valInt(scanner, 1, 6);
            System.out.println("\n=======================================");
    
            switch (choice) {
                case 1 -> appointmentController.scheduleAppointment(scanner, patient, doctor, nurse);
                case 2 -> appointmentController.updateAppointment(scanner);
                case 3 -> appointmentController.cancelAppointment(scanner);
                case 4 -> appointmentController.searchAppointment(scanner);
                case 5 -> appointmentController.filterAppointments(scanner);
                case 6 -> {
                    System.out.println("\nExiting...");
                    return;
                }
                default -> System.out.println("\nERROR! Invalid option. Please try again.");
            }
        }
    }
}