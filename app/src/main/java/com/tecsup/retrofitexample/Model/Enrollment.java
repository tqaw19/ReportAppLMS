package com.tecsup.retrofitexample.Model;

import java.util.List;

public class Enrollment {
    private int course_id;
    private boolean enrollment_state;
    private List<Grades> gradesList;

    public int getCourse_id() {
        return course_id;
    }

    public boolean isEnrollment_state() {
        return enrollment_state;
    }

    public List<Grades> getGradesList() {
        return gradesList;
    }

    public static class Grades{
        private Double final_score;

        public Double getFinal_score() {
            return final_score;
        }
    }
}
