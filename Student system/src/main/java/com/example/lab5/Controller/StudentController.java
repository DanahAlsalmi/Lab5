package com.example.lab5.Controller;

import com.example.lab5.Api.ApiResponse;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    //Read
    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    //Add
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Successfully added student");
    }

    //Update
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student, @PathVariable int index) {
        students.set(index, student);
        return new ApiResponse("Successfully updated student");
    }

    //Delete
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Successfully deleted student");
    }
    //name
    @GetMapping("/name/{index}")
    public ApiResponse getName(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            return new ApiResponse(students.get(index).getName());
        }
        return new ApiResponse("Student not found");
    }

    //Age
    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index).getAge();
        }
        return 0;
    }
    //Degree
    @GetMapping("/college/degree/{index}")
    public ApiResponse getDegree(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            return new ApiResponse(students.get(index).getDegree());
        }
        return new ApiResponse("Student not found");
    }
    //Status
    @GetMapping("/study/status/{index}")
    public boolean getGraduationStatus(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            if (students.get(index).getStatus().equalsIgnoreCase("graduated")) {
                return true;
            }
        }
        return false;
    }


}
