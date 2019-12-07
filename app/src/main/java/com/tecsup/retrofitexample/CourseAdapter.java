package com.tecsup.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.retrofitexample.EnrollmentActivity;

import com.tecsup.retrofitexample.Model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private static final String TAG = CourseAdapter.class.getSimpleName();

    private EnrollmentActivity activity;

    private List<Course> courses;

    public CourseAdapter() {
        this.activity = activity;
        this.courses = new ArrayList<>();
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        /**Using ProgressBar Widget*/
        //public ProgressBar progressBar;

        public TextView textViewCourseid;
        public TextView textViewCoursename;
        public TextView textViewCoursecode;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            textViewCourseid = itemView.findViewById(R.id.textViewCourse_id);
            textViewCoursename = itemView.findViewById(R.id.textViewCourse_name);
            textViewCoursecode = itemView.findViewById(R.id.textViewCourse_code);
            //progressBar = itemView.findViewById(R.id.progressbar);


        }
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_course, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CourseAdapter.ViewHolder viewHolder, final int position) {

        final Context context = viewHolder.itemView.getContext();
        final Course course = this.courses.get(position);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        viewHolder.textViewCourseid.setText(String.valueOf(course.getId()));
        viewHolder.textViewCoursename.setText(course.getName());
        viewHolder.textViewCoursename.setTextColor(currentColor);
        viewHolder.textViewCoursecode.setText(course.getCourse_code());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EnrollmentActivity.class);
                intent.putExtra("course_id", course.getId());
                context.startActivity(intent);
                Log.d(TAG, "course_id_CourseAdapter: " + course.getId());
            }
        });

        //.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return this.courses.size();
    }
}
