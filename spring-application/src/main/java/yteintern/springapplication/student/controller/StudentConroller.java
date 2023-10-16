package yteintern.springapplication.student.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yteintern.springapplication.common.response.MessageResponse;
import yteintern.springapplication.student.controller.request.StudentAddRequest;
import yteintern.springapplication.student.controller.request.StudentUpdateRequet;
import yteintern.springapplication.student.controller.response.StudentResponse;
import yteintern.springapplication.student.entity.Student;
import yteintern.springapplication.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentConroller {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid StudentAddRequest studentAddRequest){
        return studentService.addStudent(studentAddRequest.toEntity());
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@NotNull @PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return new StudentResponse(student);
    }

    @GetMapping
    public List<StudentResponse> getStudents(){
        List<Student> students = studentService.getStudents();
        return students.stream()
                .map(StudentResponse::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(@PathVariable Long id , @RequestBody StudentUpdateRequet studentUpdateRequet){
        return studentService.updateStudent(id , studentUpdateRequet);
    }


}
