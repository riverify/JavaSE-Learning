package com.river.map;

import com.river.set.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用Map储存学号和学生的映射
 */
public class TestMap2 {
    public static void main(String[] args) {
        //1.创建一个Map对象
        Map<String, Student> map = new HashMap<String, Student>();

        //2.向Map对象中添加多个键值对
        Student stu1 = new Student("114514", "Alice", 19, 93);
        Student stu2 = new Student("114515", "Lee", 23, 89);
        Student stu3 = new Student("114516", "Joe", 23, 94);
        Student stu4 = new Student("114514", "Alice", 19, 93);
        map.put(stu1.getStuNum(), stu1);
        map.put(stu2.getStuNum(), stu2);
        map.put(stu3.getStuNum(), stu3);
        map.put(stu4.getStuNum(), stu4);

        //3.遍历输出
        System.out.println(map.size());
        System.out.println(map.get("114514"));
        Set<Map.Entry<String, Student>> entrySet = map.entrySet();

        //a遍历
        Iterator<Map.Entry<String, Student>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry);
        }
        //b遍历
        for (Map.Entry<String, Student> entry : entrySet){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

        //4.其它方法
        map.remove("114515");
        map.clear();
        map.isEmpty();
        map.containsKey("114513");
//        map.putAll();
    }
}
