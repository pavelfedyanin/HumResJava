package com.ks.hr.fedpavel.db;

import com.ks.hr.fedpavel.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 23.06.14.
 */
public class DepartmentsDB {

    private Connection conn = null;

    public DepartmentsDB(Connection conn) {
        this.conn = conn;
    }



    /** %
     *
     * @return
     * @throws SQLException
     */
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        try ( Statement statement = conn.createStatement()) {
            ResultSet resSet = statement.executeQuery("SELECT * FROM departments");
            while (resSet.next()) {
                Department department = new Department(resSet.getInt("id"), resSet.getString("name"));
                departments.add(department);
                //System.out.println(department.toString());
            }
        }
        return departments;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Department getDepartmentById(Integer id) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM departments WHERE id=?");
        statement.setInt(1, id);
        ResultSet resSet = statement.executeQuery();
        while (resSet.next()) {
            Department department = new Department(resSet.getInt("id"), resSet.getString("name"));
            // System.out.println(department);
            return department;
        }
        return null;
    }

    /**
     *
     * @param department
     * @throws SQLException
     */
    public void saveDepartmentToDB(Department department) throws SQLException {
        if (department.getId() == null){// save to db
            PreparedStatement st = conn.prepareStatement("INSERT INTO departments (name) VALUES (?)");
            st.setString(1, department.getName());
            st.execute();
        } else { //update record in db
            PreparedStatement st = conn.prepareStatement("UPDATE departments SET  name =  (?) WHERE  departments.id = (?)");
            st.setString(1, department.getName());
            st.setInt(2, department.getId());
            st.execute();
        }
    }

}
