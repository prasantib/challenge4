package com.company;

public class Link {
    private long id;
    private long classId;
    private long studentId;
    private long facultyId;

    public Link() {
    }

    public Link(long classId, long studentId, long id, long facultyId) {
        this.classId = classId;
        this.studentId = studentId;
        this.id = id;
        this.facultyId = facultyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }
}