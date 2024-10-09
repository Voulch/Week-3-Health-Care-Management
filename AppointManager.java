// Class AppointmentManager to manage Appointments
package Healthcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppointManager {
    private final Map<String, Appointment> appointments = new HashMap<>();
    private final List<String> availableTimes;

    public AppointManager() {
        availableTimes = new ArrayList<>();
        availableTimes.add("October 8, 2024 | 10:00 AM - 12:00 PM");
        availableTimes.add("October 8, 2024 | 1:00 PM - 3:00 PM");
        availableTimes.add("October 8, 2024 | 5:00 PM - 7:00 PM");
        availableTimes.add("October 9, 2024 | 10:00 AM - 12:00 PM");
        availableTimes.add("October 9, 2024 | 1:00 PM - 3:00 PM");
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }
    
    boolean appointmentExists(String appointmentID) {
        return appointments.containsKey(appointmentID);
    }

    public String addAppointment(Appointment appointment) {
        if (availableTimes.contains(appointment.getDateTime())) {
            appointments.put(appointment.getAppointmentID(), appointment);
            availableTimes.remove(appointment.getDateTime());
            return appointment.scheduleAppointment();
        } else {
            return "\nERROR! The Schedule you selected is Unavailable.";
        }
    }

    public String updateAppointment(String appointmentID, String newDateTime) {
        Appointment appointment = appointments.get(appointmentID);
        if (appointment != null && availableTimes.contains(newDateTime)) {
            availableTimes.remove(newDateTime);
            availableTimes.add(appointment.dateTime);
            appointment.updateAppointment(newDateTime);
            return "\nUpdated: " + appointment.viewAppointment();
        } else {
            return "\nERROR! ID not found or the recently choose Schedule is Unvailable.";
        }
    }

    public String cancelAppointment(String appointmentID) {
        Appointment appointment = appointments.get(appointmentID);
        if (appointment != null) {
            availableTimes.add(appointment.getDateTime());
            appointment.status = "cancelled";
            return appointment.cancelAppointment();
        } else {
            return "\nERROR! ID not found.";
        }
    }

    public List<Appointment> searchAppointments(String searchValue) {
        List<Appointment> searchResults = new ArrayList<>();
        for (Appointment appointment : appointments.values()) {
            if (appointment.getAppointmentID().equals(searchValue)) {
                searchResults.add(appointment);
            }
        }
        return searchResults;
    }

    public List<Appointment> filterAppointmentsByStatus(String status) {
        List<Appointment> filteredAppointments = new ArrayList<>();
        for (Appointment appointment : appointments.values()) {
            if (appointment.getStatus().equalsIgnoreCase(status)) {
                filteredAppointments.add(appointment);
            }
        }
        return filteredAppointments;
    }
}