package yteintern.springapplication.student.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yteintern.springapplication.common.response.MessageResponse;
import yteintern.springapplication.common.response.MessageType;
import yteintern.springapplication.student.controller.request.StudentUpdateRequet;
import yteintern.springapplication.student.entity.Student;
import yteintern.springapplication.student.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public MessageResponse addStudent(Student student){
        studentRepository.save(student);
        return new MessageResponse("Student Has Been Added Successfully" , MessageType.SUCCESS);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public MessageResponse deleteStudent(Long id) {

        if(!studentRepository.existsById(id)){
            return new MessageResponse("Student can't be found" , MessageType.ERROR);
        }

        studentRepository.deleteById(id);
        return new MessageResponse("Student has been deleted Successfully" , MessageType.SUCCESS);
    }

    @Transactional
    public MessageResponse updateStudent(Long id, StudentUpdateRequet studentUpdateRequet) {
        Student student = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        student.update(studentUpdateRequet);
        studentRepository.save(student);

        return new MessageResponse("Student has been updated successfully" , MessageType.SUCCESS);

    }
}
