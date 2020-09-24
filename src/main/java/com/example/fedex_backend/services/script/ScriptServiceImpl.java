package com.example.fedex_backend.services.script;

import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.script.ScriptDTO;
import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.services.program.ProgramService;
import com.example.fedex_backend.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptServiceImpl implements ScriptService {
    private StudentService studentService;
    private ProgramService programService;

    @Autowired
    public ScriptServiceImpl(StudentService studentService, ProgramService programService) {
        this.studentService = studentService;
        this.programService = programService;
    }

    @Override
    public void manageScript(ScriptDTO scriptDTO) {
        Student student = new Student(scriptDTO.getStudentDTO());
        Student savedStudent = studentService.addStudent(student);
        List<Program> programList = programService.savePrograms(savedStudent, scriptDTO.getProgramDTOList());
        savedStudent.setPrograms(programList);
        studentService.saveStudent(savedStudent);
    }
}
