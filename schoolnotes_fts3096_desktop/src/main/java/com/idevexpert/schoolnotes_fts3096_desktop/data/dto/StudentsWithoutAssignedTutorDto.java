/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentsWithoutAssignedTutorDto {

    public  Long idStudentAccount;
    public String studentCode;
    public String studentName;
    public String studentLastname;
    public String studentMotherLastname;
}
