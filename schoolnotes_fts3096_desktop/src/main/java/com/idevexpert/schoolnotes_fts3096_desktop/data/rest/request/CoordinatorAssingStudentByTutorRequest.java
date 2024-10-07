package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request;

import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorAssingStudentByTutorRequest {

    private Long tutorAccountId;
    private Long studentAccountId;

}
