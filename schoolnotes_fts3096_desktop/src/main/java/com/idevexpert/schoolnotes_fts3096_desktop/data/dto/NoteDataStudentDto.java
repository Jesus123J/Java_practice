package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class NoteDataStudentDto {

    private String code;
    private String esp;
    private String names;
    private String lastname;
    private String motherLastname;
    private List<NoteValueDataStudentDto> notes;

}
