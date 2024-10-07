/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;

    
import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.SituationsSentToTheTeacherDto;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherListCaseResponse {

    private Integer code;
    private String message;
    private List<SituationsSentToTheTeacherDto> listSituationsSentToTheTeacher;

}
