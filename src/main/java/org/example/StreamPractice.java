package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class StreamPractice {

   static boolean isAnagram(String str1, String str2){
        return  str1.length() == str2.length() &&
                Arrays.equals(str1.toLowerCase().chars().sorted().toArray(),
                        str2.toLowerCase().chars().sorted().toArray());
    }
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rafi",9500));
        employees.add(new Employee("Ahmed",9500));
        employees.add(new Employee("Shakeel",8500));
        employees.add(new Employee("Kamran",9800));
        employees.add(new Employee("Samad",7800));

        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName));
        employees.forEach(System.out::println);


        List<String> words = Arrays.asList("Java","Python","Java","Python","DSA","DBMS","JS","CSS");
       String secondFrequentNum = words.stream().collect(Collectors.groupingBy(s-> s, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(secondFrequentNum);

        System.out.println(isAnagram("Rafi","Afri"));


    }
}
