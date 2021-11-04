package ex6;

import java.util.Date;
import java.util.List;

public class Profs extends Personel {
    public Profs(String name, String firstName, String email, Date birthDate) {
        super(name, firstName, email, birthDate);
    }


    public List<Courses> courses;

    public void joinCourses(Courses course) {
        courses.add(course);
    }

}
