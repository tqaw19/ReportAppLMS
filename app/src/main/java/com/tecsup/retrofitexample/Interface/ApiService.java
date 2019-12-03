package com.tecsup.retrofitexample.Interface;

import com.tecsup.retrofitexample.Model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String API_BASE_URL = "https://canvas-api2019.herokuapp.com/api/";

    @GET("courses")
    Call<List<Course>> getCourses();
}

