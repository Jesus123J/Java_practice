package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.StudentsAssignedByTutorDto;
import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorStudentsAssignedByTutorResponse {

    
    private Integer code;
    private String message;
    private List<StudentsAssignedByTutorDto> listStudentsAssignedByTutor;

}
