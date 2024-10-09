// Appointment Manager it manages the appointments
package Healthcare;

import java.util.List;
import java.util.Scanner;

public class AppointController {
    private final AppointManager appointmentManager;
    final Validation validation;

    public AppointController(AppointManager appointmentManager, Validation validation) {
        this.appointmentManager = appointmentManager;
        this.validation = validation;
    }

    public void scheduleAppointment(Scanner scanner, Patient patient, Doctor doctor, Nurse nurse) {
        System.out.println("\nAvailable times:\n");
        List<String> availableTimes = appointmentManager.getAvailableTimes();
        for (int i = 0; i < availableTimes.size(); i++) {
            System.out.println((i + 1) + ". " + availableTimes.get(i));
        }
        System.out.print("\nChoose a Schedule: ");
        int timeChoice = validation.valInt(scanner, 1, availableTimes.size());
        String chosenTime = availableTimes.get(timeChoice - 1);

        System.out.print("\nEnter an appointment ID: ");
        String appointmentID = validation.valString(scanner);

        if (appointmentManager.appointmentExists(appointmentID)) {
            System.out.println("\nAppointment ID already exists. Please choose a different ID.");
            return;
        }

        Appointment appointment = new Appointment(appointmentID, chosenTime, patient, doctor, nurse);
        String result = appointmentManager.addAppointment(appointment);
        System.out.println(result);
    }

    public void updateAppointment(Scanner scanner) {
        System.out.print("\nEnter an appointment ID: ");
        String appointmentID = validation.valString(scanner);

        if (!appointmentManager.appointmentExists(appointmentID)) {
            System.out.println("\nERROR! Appointment ID does not exist.");
            return;
        }

        System.out.println("\nAvailable times:");
        List<String> availableTimes = appointmentManager.getAvailableTimes();
        for (int i = 0; i < availableTimes.size(); i++) {
            System.out.println((i + 1) + ". " + availableTimes.get(i));
        }
        System.out.print("\nChoose a new Schedule: ");
        int timeChoice = validation.valInt(scanner, 1, availableTimes.size());
        String newTime = availableTimes.get(timeChoice - 1);

        String result = appointmentManager.updateAppointment(appointmentID, newTime);
        System.out.println(result);
    }

    public void cancelAppointment(Scanner scanner) {
        System.out.print("\nEnter appointment ID: ");
        String appointmentID = validation.valString(scanner);

        if (!appointmentManager.appointmentExists(appointmentID)) {
            System.out.println("\nERROR! Appointment ID does not exist.");
            return;
        }

        String result = appointmentManager.cancelAppointment(appointmentID);
        System.out.println(result);
    }

    public void searchAppointment(Scanner scanner) {
        System.out.print("\nEnter appointment ID: ");
        String searchValue = validation.valString(scanner);

        List<Appointment> searchResults = appointmentManager.searchAppointments(searchValue);
        if (searchResults.isEmpty()) {
            System.out.println("\nERROR! No appointments found.");
        } else {
            for (Appointment appointment : searchResults) {
                System.out.println(appointment.viewAppointment());
            }
        }
    }

    public void filterAppointments(Scanner scanner) {
        System.out.println("\nChoose an appointment status:");
        System.out.println("1. Scheduled");
        System.out.println("2. Cancelled");
        System.out.print("Enter your choice [1 or 2]: ");
        int choice = validation.valInt(scanner, 1, 2);
    
        String status = choice == 1 ? "Scheduled" : "Cancelled";
    
        List<Appointment> filteredAppointments = appointmentManager.filterAppointmentsByStatus(status);
        if (filteredAppointments.isEmpty()) {
            System.out.println("\nERROR! No appointments found with the specified status.");
        } else {
            for (Appointment appointment : filteredAppointments) {
                System.out.println(appointment.viewAppointment());
            }
        }
    }
}