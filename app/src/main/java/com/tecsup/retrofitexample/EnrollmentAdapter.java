package com.tecsup.retrofitexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.retrofitexample.Model.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentAdapter extends RecyclerView.Adapter<EnrollmentAdapter.ViewHolder> {

    private List<Enrollment> enrollments;

    public EnrollmentAdapter() {
        this.enrollments = new ArrayList<>();
    }

    public void setEnrollments(List<Enrollment> enrollments){
        this.enrollments= enrollments;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView fotoimage;
        public TextView textViewEnrollmentusername;
        public TextView textViewEnrollmentstate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoimage = itemView.findViewById(R.id.foto_image);
            textViewEnrollmentusername = itemView.findViewById(R.id.textViewEnrollment_user_name);
            textViewEnrollmentstate = itemView.findViewById(R.id.textViewEnrollment_state);
        }
    }

    @NonNull
    @Override
    public EnrollmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_enrollent, parent, false);
        return new EnrollmentAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EnrollmentAdapter.ViewHolder viewHolder, int position) {
        Enrollment enrollment = this.enrollments.get(position);
        viewHolder.textViewEnrollmentusername.setText(enrollment.getUser().getName());
        viewHolder.textViewEnrollmentstate.setText(enrollment.isEnrollment_state());
    }

    @Override
    public int getItemCount() {
        return this.enrollments.size();
    }
}
