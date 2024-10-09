// Child class of Person it is focused on the specific data of the nurses which is all stored in a linkedlist.
package Healthcare;
import java.util.LinkedList;

public class Nurse extends User {
    private final String department;

    public Nurse(String id, String name, String dateOfBirth, String contact, String department) {
        super(id, name, dateOfBirth, contact);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public static LinkedList<Nurse> createNurses() {
        LinkedList<Nurse> nurses = new LinkedList<>();

        nurses.add(new Nurse("0001", "Nurse Joy", "January 12, 2001", "7777777", "ICU"));
        nurses.add(new Nurse("0002", "Nurse Alicia", "December 15, 2000", "55555555", "ER"));
        nurses.add(new Nurse("0003", "Nurse Madison", "May 10, 1999", "44444444", "Surgery"));

        return nurses;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
