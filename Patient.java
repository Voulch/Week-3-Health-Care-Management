// Patient class stores the data of patients and it takes their information to provide good medication or prescriptions.
package Healthcare;
import java.util.ArrayList;

public class Patient extends User {
    private final ArrayList<MedicalLog> medicalLogs;

    public Patient(String id, String name, String dateOfBirth, String contact) {
        super(id, name, dateOfBirth, contact);
        this.medicalLogs = new ArrayList<>();
    }

    public void addLog(MedicalLog log) {
        this.medicalLogs.add(log);
    }

    public void viewBilling() {
        System.out.println("\n========== Patient Reciept ============");
        System.out.println("\nPatient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Phone Number: " + getContact());
        System.out.println("Medical Logs:");
        for (MedicalLog log : medicalLogs) {
            log.displayLog();
        }
        System.out.println("Medical Bills:");
        // Will Implement on the last week.
        System.out.println("\n=======================================");
    }
}