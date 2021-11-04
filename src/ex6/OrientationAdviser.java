package ex6;

import java.util.Date;
import java.util.List;

public class OrientationAdviser extends Personel {
    public OrientationAdviser(String name, String firstName, String email, Date birthDate) {
        super(name, firstName, email, birthDate);
    }

    private List<OrientationApointment> apointments;

    public void addApointment(OrientationApointment apointment) {
        this.apointments.add(apointment);
    }

}
