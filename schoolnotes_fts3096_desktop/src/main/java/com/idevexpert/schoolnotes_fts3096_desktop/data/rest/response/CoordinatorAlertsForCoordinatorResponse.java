package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.AlertsForCoordinatorDto;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorAlertsForCoordinatorResponse {

    private Integer code;
    private String message;
    private AlertsForCoordinatorDto summaryAlerts;

}
