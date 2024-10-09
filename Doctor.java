// Child class of Person it is focused on the specific data of the doctors which is all stored in a linkedlist.
package Healthcare;
import java.util.LinkedList;

public class Doctor extends User {
    private final String specialty;
    private final LinkedList<Patient> patients;

    public Doctor(String id, String name, String dateOfBirth, String contact, String specialty) {
        super(id, name, dateOfBirth, contact);
        this.specialty = specialty;
        this.patients = new LinkedList<>();
    }

    public String getSpecialty() {
        return specialty;
    }

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public static LinkedList<Doctor> createDoctors() {
        LinkedList<Doctor> doctors = new LinkedList<>();

        doctors.add(new Doctor("001", "Dr. Brannon", "January 10, 1994", "1111111111", "Cardiology"));
        doctors.add(new Doctor("002", "Dr. Jacob", "March 11, 1990", "2222222222", "Neurology"));
        doctors.add(new Doctor("003", "Dr. Brown", "June 12, 1980", "333333333", "Pediatrics"));

        return doctors;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}