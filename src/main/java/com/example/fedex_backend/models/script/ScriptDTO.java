package com.example.fedex_backend.models.script;

import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.models.student.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScriptDTO {
    private StudentDTO studentDTO;
    private List<ProgramDTO> programDTOList;
}
