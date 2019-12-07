package com.tecsup.retrofitexample.Model;

import java.util.List;

public class Enrollment {
    private int course_id;
    private String enrollment_state;
    private Grades grades;
    private User user;

    public int getCourse_id() {
        return course_id;
    }

    public String isEnrollment_state() {
        return enrollment_state;
    }

    public Grades getGrades() {
        return grades;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "course_id=" + course_id +
                ", enrollment_state=" + enrollment_state +
                ", grades=" + grades +
                ", user=" + user +
                '}';
    }

    public class Grades{
        private double current_score;

        public double getCurrent_score() {
            return current_score;
        }
    }

    public class User{
        private String name;
        private String integration_id;

        public String getName() {
            return name;
        }

        public String getIntegration_id() {
            return integration_id;
        }
    }
}
