package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "Students")
public class Student extends User{
    @Column
    private int studyYear;

    public Student(){};

    public Student(String name, Date dateOfBirth, Account account){
        super(name, dateOfBirth, account);
        studyYear = 1;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }
}
