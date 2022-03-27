package com.river.set;

public class Student implements Comparable<Student> {
    private String StuNum;
    private String StuName;
    private int StuAge;
    private int Grade;

    @Override
    public int compareTo(Student o) {
        return this.Grade - o.Grade;
    }

    public Student(){super();}

    public Student(String stuNum, String stuName, int stuAge, int grade) {
        StuNum = stuNum;
        StuName = stuName;
        StuAge = stuAge;
        Grade = grade;
    }

    public String getStuNum() {
        return StuNum;
    }

    public void setStuNum(String stuNum) {
        StuNum = stuNum;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public int getStuAge() {
        return StuAge;
    }

    public void setStuAge(int stuAge) {
        StuAge = stuAge;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StuNum='" + StuNum + '\'' +
                ", StuName='" + StuName + '\'' +
                ", StuAge=" + StuAge +
                ", Grade=" + Grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (StuAge != student.StuAge) return false;
        if (Grade != student.Grade) return false;
        if (StuNum != null ? !StuNum.equals(student.StuNum) : student.StuNum != null) return false;
        return StuName != null ? StuName.equals(student.StuName) : student.StuName == null;
    }


    @Override
    public int hashCode() {
        int result = StuNum != null ? StuNum.hashCode() : 0;
        result = 31 * result + (StuName != null ? StuName.hashCode() : 0);
        result = 31 * result + StuAge;
        result = 31 * result + Grade;
        return result;
    }
}
