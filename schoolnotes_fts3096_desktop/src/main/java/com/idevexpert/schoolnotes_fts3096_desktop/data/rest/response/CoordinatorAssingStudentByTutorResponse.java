package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.entity.PersonTutorStudentTb;
import lombok.Data;

/*
@author YANPIER
 */

@Data
public class CoordinatorAssingStudentByTutorResponse {
    
    private Integer code;
    private String message;
    private PersonTutorStudentTb personTutorStudent;
    
}
