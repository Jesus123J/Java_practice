package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.SummaryForCoordinatorDto;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorSummaryForCoordinatorResponse {

    private Integer code;
    private String message;
    private SummaryForCoordinatorDto summaryInformation;

}
