package ex6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends User {
    private List<OrientationApointment> orientationApointments = new ArrayList<>();

    private List<Courses> courses;

    public Student(String name, String firstName, String email, Date birthDate) {
        super(name, firstName, email, birthDate);
    }

    public void joinCourse(Courses course) {
        this.courses.add(course);
    }

    private boolean isDayWithin7Days(Date date) {
        return date.getTime() - new Date().getTime() < 7 * 24 * 60 * 60 * 1000;
    }

    @Override
    public void setAtRisk(boolean atRisk) {
        super.setAtRisk(atRisk);

        if (atRisk == true) {
            this.courses.stream().filter(course -> course.wasPresent(this)).
                    filter(course -> isDayWithin7Days(course.getStartDate()) ).
                    forEach(course -> {
                        course.getProfs().setAtRisk(true);
                        course
                                .presentStudents()
                                .stream()
                                .forEach(student -> student.setAtRisk(true));
                    });
        }
    }

    public List<OrientationApointment> getOrientationApointments() {
        return orientationApointments;
    }

    private boolean isSameDay(Date date1, Date date2) {
        return date1.getDay() == date2.getDay() && date1.getMonth() == date2.getMonth() && date1.getYear() == date2.getYear();
    }

    public void takeApointment(OrientationApointment orientationApointment) throws Exception {

        boolean isOnDayOff = orientationApointment.getAdviser()
                .getDaysOff()
                .stream()
                .anyMatch(dayOff -> isSameDay(orientationApointment.getDate(), dayOff));

        if (isOnDayOff) {
            throw new Exception("The adviser is off on this day");
        }
        this.orientationApointments.add(orientationApointment);
    }

}
