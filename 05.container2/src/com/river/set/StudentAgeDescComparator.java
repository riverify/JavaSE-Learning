package com.river.set;

import java.util.Comparator;

/**
 * 按年纪降序排列
 */
public class StudentAgeDescComparator implements Comparator<Student> {
    @Override
    public int compare(Student stu1, Student stu2) {
        double age1 = stu1.getStuAge();
        double age2 = stu2.getStuAge();
        if (age1 > age2){
            return -1;
        }else if (age1 < age2){
            return 1;
        }else{
            return stu1.getGrade() - stu2.getGrade();
        }
    }
}
