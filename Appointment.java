// Class Appointment to take Appointments
package Healthcare;

public class Appointment {
    private final String appointmentID;
    String dateTime;
    String status;
    private final Doctor doctor;
    private final Nurse nurse;

    public Appointment(String appointmentID, String dateTime, Patient patient, Doctor doctor, Nurse nurse) {
        this.appointmentID = appointmentID;
        this.dateTime = dateTime;
        this.status = "Scheduled";
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void updateAppointment(String newDateTime) {
        this.dateTime = newDateTime;
    }

    public String scheduleAppointment() {
        return "\nAppointment Scheduled: " + appointmentID + " on " + dateTime;
    }

    public String cancelAppointment() {
        this.status = "Cancelled";
        return "\nAppointment Cancelled: " + appointmentID + " on " + dateTime;
    }

    public String viewAppointment() {
        return "\nAppointment ID: " + appointmentID + 
               "\nDate and Time: " + dateTime + 
               "\nStatus: " + status + 
               "\nDoctor: " + doctor.getName() + 
               "\nNurse: " + nurse.getName();
    }
}