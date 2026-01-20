package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final Connection connection;

    public Service(Connection connection){
        this.connection = connection;
    }

    public void addClass(String className)throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO classes(class)VALUES(?)");
        ps.setString(1,className);
        if(ps.executeUpdate()>0){
            System.out.println("Class Added Successfully");
        }
        ps.close();
    }

    public Class getClass(int classId)throws SQLException{
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM classes WHERE id = ?");
        ps.setInt(1,classId);
        ResultSet rs = ps.executeQuery();
        Class aClass = null;
        if(rs.next()){
            aClass = new Class(rs.getInt("id"),rs.getString("class"));
        }
        ps.close();
        rs.close();
        return aClass;
    }

    public void addStudent(int classId, String name)throws SQLException{
        Class aClass = getClass(classId);
        if(aClass==null){
            System.out.println("Class Not Found");
            return;
        }
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students(name,class_id)VALUES(?,?)");
        ps.setString(1,name);
        ps.setInt(2,aClass.getId());
        if(ps.executeUpdate()>0){
            System.out.println("Student Added Successfully");
        }
        ps.close();
    }

    public List<Student> getStudentList()throws SQLException{
        PreparedStatement ps = connection.prepareStatement(
                "SELECT students.* , classes.* FROM students INNER JOIN classes" +
                        " ON students.class_id = classes.id"
        );
        ResultSet rs = ps.executeQuery();
        List<Student> students = new ArrayList<>();
        while(rs.next()){
            Class aClass = new Class(rs.getInt("id"),rs.getString("class"));
            Student student = new Student(rs.getInt("id"),rs.getString("name"),aClass);
            students.add(student);
        }
        ps.close();
        rs.close();
        return students;
    }
}
