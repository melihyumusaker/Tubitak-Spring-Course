package yteintern.springapplication.student.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yteintern.springapplication.common.BaseEntity;
import yteintern.springapplication.student.controller.request.StudentUpdateRequet;

@Entity
@NoArgsConstructor
@Getter
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;
    public Student(String name, String surname, String email, String tcKimlikNo, String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tcKimlikNo = tcKimlikNo;
        this.studentNumber = studentNumber;
    }

    public void updateStudentInformationForDepartmentChange(String email ,String studentNumber){
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public void update(StudentUpdateRequet studentUpdateRequet){
        this.name = studentUpdateRequet.name();
        this.surname = studentUpdateRequet.surname();
        this.email = studentUpdateRequet.email();
        this.studentNumber = studentUpdateRequet.studentNumber();
    }



}
