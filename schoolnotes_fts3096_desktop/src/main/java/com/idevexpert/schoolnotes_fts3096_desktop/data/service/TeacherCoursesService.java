package com.idevexpert.schoolnotes_fts3096_desktop.data.service;

import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherListStudentsRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherListCoursesWithClassroomResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherListStudentsResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author YANPIER
 */
public interface TeacherCoursesService {
    
    @GET("api/teacher/courses/list-courses-with-classroom")
    @Headers("Content-Type: application/json")
    Call<TeacherListCoursesWithClassroomResponse> listCoursesWithClassroomResponse(@Header("Authorization") String authorizationHeader);

    @POST("api/teacher/courses/list-students-by-course-and-classroom")
    @Headers("Content-Type: application/json")
    Call<TeacherListStudentsResponse> listStudentsResponse(@Header("Authorization") String authorizationHeader, @Body TeacherListStudentsRequest teacherListStudentsRequest);

    
}
