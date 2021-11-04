package ex6;

import java.util.Date;

public class OrientationApointment {


    private OrientationAdviser adviser;
    private Student student;
    private Date date;

    public OrientationApointment(OrientationAdviser adviser, Student student, Date date) {
        this.adviser = adviser;
        this.student = student;
        this.date = date;

        this.adviser.addApointment(this);
    }

    public OrientationAdviser getAdviser() {
        return adviser;
    }

    public void setAdviser(OrientationAdviser adviser) {
        this.adviser = adviser;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
