/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;

import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.ListCoursesToBeAssignedDto;
import java.util.List;
import lombok.Data;

@Data
public class CoordinatorListCoursesToBeAssignedResponse {

    private Integer code;
    private String message;
    private List<ListCoursesToBeAssignedDto> courseList;

}