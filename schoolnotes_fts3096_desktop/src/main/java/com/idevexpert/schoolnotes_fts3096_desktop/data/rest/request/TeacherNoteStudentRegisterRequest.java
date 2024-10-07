package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.NoteDataStudentDto;
import java.util.List;
import lombok.Data;

/*
@author YANPIER
 */
@Data
public class TeacherNoteStudentRegisterRequest {

    private List<String> noteTypes;
    private Long idCourseTeacher;
    private List<NoteDataStudentDto> noteDataStudent;

}
