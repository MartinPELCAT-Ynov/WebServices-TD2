package ex6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Courses {

    private Profs profs;
    private List<Student> students = new ArrayList();
    private List<Student> presentStudents = new ArrayList();
    private Date startDate;
    private Date endDate;

    private Boolean isRemote;

    public Courses(Profs profs, Date startDate, Date endDate, Boolean isRemote) {
        this.profs = profs;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isRemote = isRemote;
    }


    public boolean wasPresent(Student student) {
        return presentStudents.contains(student);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addPresentStudent(Student student) {
        presentStudents.add(student);
    }

    public List<Student> presentStudents() {
        return presentStudents;
    }

    public List<Student> students() {
        return students;
    }

    public Profs getProfs() {
        return profs;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getIsRemote() {
        return isRemote;
    }

}
