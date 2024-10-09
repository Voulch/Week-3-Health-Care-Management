// Mediical Log it shows the log that is created from the program it also stores the results and prescription on an Array list.
package Healthcare;
import java.util.ArrayList;

public class MedicalLog {
    private final String logId;
    private final Patient patient;
    private final Doctor doctor;
    private Nurse nurse;
    private final ArrayList<String> prescriptions;
    private final ArrayList<String> testResults;

    public MedicalLog(String logId, Patient patient, Doctor doctor) {
        this.logId = logId;
        this.patient = patient;
        this.doctor = doctor;
        this.prescriptions = new ArrayList<>();
        this.testResults = new ArrayList<>();
    }

    public void addStaff(Nurse nurse) {
        this.nurse = nurse;
    }

    public void addPrescription(String prescription) {
        this.prescriptions.add(prescription);
    }

    public void addTestResult(String testResult) {
        this.testResults.add(testResult);
    }

    public void displayLog() {
        System.out.println("\n============= Medical Log =============");
        System.out.println("\nLog ID: " + logId);
        System.out.println("Patient ID: " + patient.getId());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Nurse: " + nurse.getName());
        System.out.println("Prescriptions: " + prescriptions);
        System.out.println("Test Results: " + testResults);
        System.out.println("\n=======================================");
    }
}