package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;

import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.PersonTutorWithAgeDto;
import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */

@Data
public class CoordinatorListPersonTutorResponse {
    
    private Integer code;
    private String message;
    private List<PersonTutorWithAgeDto> listPersonTutor;
    
}
