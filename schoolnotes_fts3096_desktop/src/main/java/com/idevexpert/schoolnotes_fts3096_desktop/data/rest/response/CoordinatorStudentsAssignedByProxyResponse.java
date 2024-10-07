package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.StudentsAssignedProxyDto;
import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorStudentsAssignedByProxyResponse {
    
  private Integer code;
    private String message;
    private List<StudentsAssignedProxyDto> listStudentsAssignedByProxy;

}