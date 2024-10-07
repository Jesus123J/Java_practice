package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.entity.PersonProxyStudentTb;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorAssingStudentByProxyResponse {
    
    private Integer code;
    private String message;
    private PersonProxyStudentTb personProxyStudentTb;
    
}
