package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class AlertsForCoordinatorDto {

    private Integer amountStudentsWithoutAssignedTutor;
    private List<StudentsWithoutAssignedTutorDto> listStudentWithoutAssignedTutor;

}
