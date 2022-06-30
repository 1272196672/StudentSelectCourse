package com.entity;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class SelectCourse {
    private int stu_id;
    private int course_id;

    public SelectCourse() {
    }

    public SelectCourse(int stu_id, int course_id) {
        this.stu_id = stu_id;
        this.course_id = course_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Select{" +
                "stu_id=" + stu_id +
                ", course_id=" + course_id +
                '}';
    }
}
