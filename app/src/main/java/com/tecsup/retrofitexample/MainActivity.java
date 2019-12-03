package com.tecsup.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tecsup.retrofitexample.Interface.ApiService;
import com.tecsup.retrofitexample.Model.Course;
import com.tecsup.retrofitexample.Singleton.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseList = findViewById(R.id.recyclerView);
        courseList.setLayoutManager(new LinearLayoutManager(this));

        courseList.setAdapter(new CourseAdapter());

        initialize();
    }

    public void initialize(){
        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Course>> call = service.getCourses();

        call.enqueue(new Callback<List<Course>>(){
            @Override
            public void onResponse(Call<List<Course>>call, Response<List<Course>> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code:" + statusCode);
                    if (response.isSuccessful()) {
                        List<Course>courses = response.body();
                        Log.d(TAG, "courses:" + courses);
                        CourseAdapter adapter = (CourseAdapter) courseList.getAdapter();
                        adapter.setCourses(courses);
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: "+ t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }
            @Override
            public void onFailure(Call<List<Course>>call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
