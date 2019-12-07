package com.tecsup.retrofitexample.Interface;

import com.tecsup.retrofitexample.Model.Course;
import com.tecsup.retrofitexample.Model.Enrollment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String API_BASE_URL = "https://canvas-api2019.herokuapp.com";

    @GET("/api/courses")
    Call<List<Course>> getCourses();

    @GET("/api/courses/{course_id}/enrollments")
    Call<List<Enrollment>> getEnrollments(@Path("course_id") Integer course_id);
}

