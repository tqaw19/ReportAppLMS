package com.tecsup.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.retrofitexample.Model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private static final String TAG = CourseAdapter.class.getSimpleName();

    private MainActivity activity;

    private List<Course> courses;

    public CourseAdapter() {
        this.activity = activity;
        this.courses = new ArrayList<>();
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCourseid;
        public TextView textViewCoursename;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            textViewCourseid = itemView.findViewById(R.id.textViewCourse_id);
            textViewCoursename = itemView.findViewById(R.id.textViewCourse_name);
        }
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CourseAdapter.ViewHolder viewHolder, final int position) {
        final Context context = viewHolder.itemView.getContext();
        final Course course = this.courses.get(position);

        viewHolder.textViewCourseid.setText( "ID: "+course.getId());
        viewHolder.textViewCoursename.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return this.courses.size();
    }
}
