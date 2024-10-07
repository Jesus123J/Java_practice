/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;

import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAssingCoursesByTeacherAccountRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorDesAssingCoursesByTeacherAccountRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorTeacherCoursesListRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAssingCoursesByTeacherAccountResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDesAssingCoursesByTeacherAccountResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListCoursesToBeAssignedResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListSectionsToBeAssignedResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListTeachersWithCoursesResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorTeacherCoursesListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Terminal G
 */
public interface CoordinatorTeacherService {
  
    @POST("api/coordinator/teacher/assigned-courses/teacher-courses-list")
    @Headers("Content-Type: application/json")
    Call<CoordinatorTeacherCoursesListResponse> listTeacherCourse(@Header("Authorization") String authorizationHeader, @Body CoordinatorTeacherCoursesListRequest coordinatorTeacherCoursesListRequest);

    @GET("api/coordinator/teacher/list-teachers-with-count-courses")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListTeachersWithCoursesResponse> listTeacherWithCourses(@Header("Authorization") String authorizationHeader);

    @GET("api/coordinator/teacher/assigned-courses/list-courses-to-be-assigned")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListCoursesToBeAssignedResponse> listCoursesToBeAssigned(@Header("Authorization") String authorizationHeader);

    @GET("api/coordinator/teacher/assigned-courses/list-sections-to-be-assigned")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListSectionsToBeAssignedResponse> listSectionsToBeAssigned(@Header("Authorization") String authorizationHeader);
    
    @POST("api/coordinator/teacher/assigned-courses/assign-courses-by-teacher-account")
     @Headers("Content-Type: application/json")
    Call<CoordinatorAssingCoursesByTeacherAccountResponse> assingCoursesByTeacherAccount(@Header("Authorization") String authorizationHeader , @Body CoordinatorAssingCoursesByTeacherAccountRequest assingCoursesByTeacherAccountRequest);

    @POST("api/coordinator/teacher/assigned-courses/desassign-courses-by-teacher-account")
    @Headers("Content-Type: application/json")
    Call<CoordinatorDesAssingCoursesByTeacherAccountResponse>desassingCoursesByTeacherAccount(@Header("Authorization") String authorizationHeader , @Body CoordinatorDesAssingCoursesByTeacherAccountRequest coordinatorDesAssingCoursesByTeacherAccountRequest);
}
