package com.river.set;

import java.util.*;

/**
 * 任意对象放入HashSet、LinkedHashSet等底层结构有哈希表的这种集合中时，必须对该对象重写hashCode() equal()
 * String类已经重写了这两个方法，故没有问题，而Student类作为用户自定义的类需要自行重写
 *
 *  任意对象放入TreeSet等底层结构是红黑树的集合中，都需要Comparable接口并实现其方法
 *  如果希望按照更多规则排序放入TreeSet等集中，可以使用外部比较器Comparator
 */

public class TestStudent {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<Student>();
        Student stu1 = new Student("114514", "Alice", 19, 93);
        Student stu2 = new Student("114515", "Lee", 23, 89);
        Student stu3 = new Student("114516", "Joe", 23, 94);
        Student stu4 = new Student("114514", "Alice", 19, 93);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        System.out.println(set.size());
        for (Student stu:set) {
            System.out.println(stu);
        }

        System.out.println("=====================================");

        Comparator comp1 = new StudentAgeDescComparator();
        Set<Student> set2 = new TreeSet<Student>(comp1);//优先使用外部比较器
        set2.add(stu1);
        set2.add(stu2);
        set2.add(stu3);
        set2.add(stu4);
        for (Student stu:set2) {
            System.out.println(stu);
        }
    }
}
