package ex6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personel extends User {

    public Personel(String name, String firstName, String email, Date birthDate) {
        super(name, firstName, email, birthDate);
    }

    private List<Date> daysOff = new ArrayList();

    public void addDayoff(Date date) {
        daysOff.add(date);
    }

    public List<Date> getDaysOff() {
        return daysOff;
    }
}
