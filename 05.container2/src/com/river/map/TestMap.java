package com.river.map;

import java.util.*;

/**
 * 使用各种Map存储国家的简称和国家的名称之间的映射
 *
 * HashMap
 *      key:无序 唯一       HashSet
 *      value:无序 不唯一   Collection
 * LinkedHashMap
 *      key:有序（添加顺序） 唯一     LinkedHashSet
 *      value:无序 不唯一           Collection
 * TreeMap
 *      key:有序（自然顺序） 唯一     TreeSet
 *      value:无序 不唯一           Collection
 *
 * Map的常用操做
 * 1.Map<String, String> map = new HashMap<String, String>();
 * 2.map.put("cn","China");
 * 3.map.get("usa");
 * 4。遍历
 *
 */
public class TestMap {
    public static void main(String[] args) {
        //创建一个Map对象
//        Map<String, String> map = new HashMap<String, String>();
//        Map<String, String> map = new LinkedHashMap<String, String>();
        Map<String, String> map = new TreeMap<String, String>();

        //向Map对象中添加键值对
        map.put("cn", "China");
        map.put("usa", "United States");
        map.put("jp", "Japan");
        map.put("fr", "France");
        map.put("usa", "America");
        map.put("uk", "United Kingdom");
        map.put("en", "United Kingdom");

        //输出Map对象的数据
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get("usa"));
        System.out.println(map.keySet()); // Set
        System.out.println(map.values()); // Collection

        //遍历1：先得到所有的key，在遍历key的过程中，再根据key获取value 不推荐
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key + "--->" + map.get(key));
        }

        //遍历2：得到所有的key-value组成的set，直接遍历set 推荐
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entries : entrySet){
//            System.out.println(entries);
            System.out.println(entries.getKey() + "===>" + entries.getValue());
        }
    }
}
