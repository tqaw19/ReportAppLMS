package com.tecsup.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tecsup.retrofitexample.Interface.ApiService;
import com.tecsup.retrofitexample.Model.Enrollment;
import com.tecsup.retrofitexample.Singleton.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnrollmentActivity extends AppCompatActivity {

    private static final String TAG = EnrollmentActivity.class.getSimpleName();
    private Integer course_id;
    private RecyclerView enrollmentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        setTitle("Enrollments");
        enrollmentlist = findViewById(R.id.recyclerView);
        enrollmentlist.setLayoutManager(new LinearLayoutManager(this));

        enrollmentlist.setAdapter(new EnrollmentAdapter());

        course_id = getIntent().getExtras().getInt("course_id");
        Log.d(TAG, "course_id_EnrollmentActivity: " + course_id);

        initialize();
    }

    public void initialize(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Enrollment>> call = service.getEnrollments(course_id);

        call.enqueue(new Callback<List<Enrollment>>() {
            @Override
            public void onResponse(Call<List<Enrollment>> call, Response<List<Enrollment>> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()){

                        List<Enrollment> enrollments = response.body();
                        Log.d(TAG, "enrollments: " + enrollments);

                        EnrollmentAdapter adapter = (EnrollmentAdapter) enrollmentlist.getAdapter();
                        adapter.setEnrollments(enrollments);
                        adapter.notifyDataSetChanged();
                    } else  {
                        Log.e(TAG, "onError: "+ response.errorBody().string());
                        throw new Exception("Ocurrio un error en el servicio");
                    }
                } catch (Throwable t){
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(EnrollmentActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Enrollment>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(EnrollmentActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
