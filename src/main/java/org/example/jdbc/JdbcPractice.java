package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcPractice {
    public static void main(String[] args)throws ClassNotFoundException{
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/couching","root","*Rafikhan12")){
            Service service = new Service(con);
            List<Student> students = service.getStudentList();
            for(Student student : students){
                System.out.println("Student Name : "+student.getName()+"  Class : "+student.getaClass().getClassName());
            }

            // Student By Class
            Map<String,List<Student>> studentsByClass =
                    students.stream().collect(Collectors.groupingBy(s-> s.getaClass().getClassName()));

            // Printing
            for(Map.Entry<String,List<Student>> e : studentsByClass.entrySet()){
                System.out.println("Class : "+e.getKey());
                for(Student s : e.getValue()){
                    System.out.println("Student Name : "+s.getName());
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
