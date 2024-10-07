/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseSituationDto {

    private Long historySituationsId;
    private String accountTypeName;
    private String historySituationTypeName;
    private String fullName;
    private String historyInformation;
    private String createTime;
}
