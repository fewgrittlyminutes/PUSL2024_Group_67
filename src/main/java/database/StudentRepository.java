package com.mycompany.studentrecordmanagement.database;

import com.mycompany.studentrecordmanagement.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE full_name LIKE ? OR email LIKE ? OR degree_program LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            String searchPattern = "%" + keyword + "%"; 
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error searching students: " + e.getMessage());
        }
        return students;
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToStudent(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error finding student: " + e.getMessage());
        }
        return null;
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (full_name, email, address, phone_number, date_of_birth, gender, degree_program, batch_number, gpa, image_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setStudentParams(stmt, student);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET full_name=?, email=?, address=?, phone_number=?, date_of_birth=?, gender=?, degree_program=?, batch_number=?, gpa=?, image_data=? WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setStudentParams(stmt, student);
            stmt.setInt(11, student.getStudentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting: " + e.getMessage());
            return false;
        }
    }

    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        return new Student(
            rs.getInt("student_id"),
            rs.getString("full_name"),
            rs.getString("email"),
            rs.getString("address"),
            rs.getString("phone_number"),
            rs.getDate("date_of_birth"),
            rs.getString("gender"),
            rs.getString("degree_program"),
            rs.getString("batch_number"),
            rs.getDouble("gpa"),
            rs.getBytes("image_data")
        );
    }

    private void setStudentParams(PreparedStatement stmt, Student student) throws SQLException {
        stmt.setString(1, student.getFullName());
        stmt.setString(2, student.getEmail());
        stmt.setString(3, student.getAddress());
        stmt.setString(4, student.getPhoneNumber());
        stmt.setDate(5, student.getDateOfBirth());
        stmt.setString(6, student.getGender());
        stmt.setString(7, student.getDegreeProgram());
        stmt.setString(8, student.getBatchNumber());
        stmt.setDouble(9, student.getGpa());
        stmt.setBytes(10, student.getImageData());
    }
}