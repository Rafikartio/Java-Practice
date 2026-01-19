package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Student{
    String name;
    int id;

    public Student(String name, int id){
        this.name=name;
        this.id = id;
    }
}

public class JavaPracticeBasics {

    public static void main(String[] args) {

        Student student = new Student("Rafi",9);
        Student student1 = new Student("Asad",8);
        Student student2 = new Student("Naveed",99);
        Student student3 = new Student("Aftab",100);
        Student student4 = new Student("Javad",89);

        Map<Integer,Student> students = new HashMap<>();
        students.put(student.id,student);
        students.put(student1.id,student1);
        students.put(student2.id,student2);
        students.put(student3.id,student3);
        students.put(student4.id,student4);

        List<Map.Entry<Integer,Student>> list = new ArrayList<>(students.entrySet());
        list.sort(Comparator.comparingInt(m-> m.getValue().id));

        Map<Integer, Student> map = list.stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v1, LinkedHashMap::new));

        System.out.println(map.containsValue(student));



    }
    }
