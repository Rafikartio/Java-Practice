package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Teacher{
    int id;
    String name;
    String department;
    int salary;

    public Teacher(int id, String name, String department,int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString(){
        return id+" - "+name+" - "+department+" - "+salary;
    }
}

public class OptionalLearn {
    public static void main(String[] args) {
        Optional<Integer> num = Optional.of(9);
        System.out.println(num);
        num.ifPresent(System.out::println);

        Map<Integer,Teacher> teachers = new HashMap<>();
        teachers.put(1,new Teacher(1,"Rafi","CS",9000));
        teachers.put(2,new Teacher(2,"Adeel","CS",8000));
        teachers.put(3,new Teacher(3,"Samar","IT",10000));
        teachers.put(4,new Teacher(4,"Papan","IT",11000));
        teachers.put(5,new Teacher(5,"Asghar","CS",12000));
        teachers.put(6,new Teacher(6,"Ismail","DATA SCIENCE",12000));

        Map<String,List<Teacher>> teachersByDepartment =
                teachers.values().stream().collect(Collectors.groupingBy(v-> v.department));

        teachersByDepartment.entrySet().forEach(System.out::println);

        Map<String,Optional<Teacher>> highestSalaryTeacherByDepartment=
                teachers.values().stream().collect(Collectors.groupingBy(t-> t.department,Collectors.maxBy(Comparator.comparingInt(t-> t.salary))));

        System.out.println(highestSalaryTeacherByDepartment);

        List<Integer> nums = Arrays.asList(8,5,7,2,4,9,9,2,3,4);
        nums.stream().sorted(Comparator.reverseOrder()).limit(3);

        Set<Integer> integers = new HashSet<>();

        nums.stream().filter(n-> !integers.add(n)).forEach(System.out::println);


    }
}
