package com.ks.hr.fedpavel.db;


import com.ks.hr.fedpavel.entities.Department;
import com.ks.hr.fedpavel.entities.Employee;
import com.ks.hr.fedpavel.entities.Position;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * Created by Pavel on 23.06.14.
 */

public class EmployeesDB {


    private Connection con = null;

    public EmployeesDB(Connection con) {
        this.con = con;

    }

    public Employee addEmployee(String name, Date birthday, String passport, Integer deparmentId, Integer positionId, BigDecimal salary) throws SQLException {
        //identify Department and position by Id
        PositionsDB positionsDB = new PositionsDB(con);
        Position position = positionsDB.getPositionById(positionId);

        DepartmentsDB departmentsDB = new DepartmentsDB(con);
        Department department = departmentsDB.getDepartmentById(deparmentId);

        //create Employee object
        Employee employee = new Employee(name, birthday, salary, passport);
        employee.setPosition(position);
        employee.setDepartment(department);

        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO employees (username, birthday, passport, salary, departmentId, positionId ) VALUES (?,?,?,?,?,?)",
                                                         Statement.RETURN_GENERATED_KEYS);
            st.setString(1, employee.getName());
            st.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            st.setString(3, employee.getPassportNumber());
            st.setBigDecimal(4, employee.getSalary());
            st.setInt(5, department.getId());
            st.setInt(6, position.getId());
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            Integer id = rs.getInt(1);
            employee.setId(id);

            System.out.print(employee);

            return employee;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException{ // Is is correct?
        Integer departmentId = null;
        return this.getAllEmployeesByDepartmentId(departmentId);
    }

    public List<Employee> getAllEmployeesByDepartmentId(Integer departmentId) throws SQLException {

        List<Employee> employees = new ArrayList<>();
        Registry<Position> positionRegistry = new Registry<Position>();
        Registry<Department> departmentRegistry = new Registry<Department>();
        String strPartOfQuery;

        if (departmentId != null){ //start of shit code, but it's better than to write two methods 1. getAllEmployeesByDepartmentId() & 2. getAllEmployees()
            strPartOfQuery ="WHERE departments.id = (?)";
        } else {
            strPartOfQuery ="";
        }

        PreparedStatement stmt = con.prepareStatement("SELECT employees.id, employees.username, employees.birthday, employees.passport, employees.salary, employees.departmentId, employees.positionId, departments.name AS departmentName, positions.name AS positionName, positions.minSalary, positions.maxSalary FROM employees " +
                                          "JOIN positions ON employees.positionId = positions.id\n" +
                                          "JOIN departments ON employees.departmentId = departments.id\n" +
                                          strPartOfQuery);

        if (departmentId != null){
            stmt.setInt(1,departmentId);
        } //end of shit code

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Employee employee = new Employee(rs.getInt("id"), rs.getString("username"),rs.getDate("birthday"), rs.getBigDecimal("salary"), rs.getString("passport"));

            Position positionFromDb = new Position(rs.getInt("positionId"), rs.getString("positionName"),rs.getBigDecimal("minSalary"),rs.getBigDecimal("maxSalary"));

            positionRegistry.addEntity(rs.getInt("positionId"), positionFromDb);
            employee.setPosition(positionRegistry.getEntity(rs.getInt("positionId")));

            Department departmentFromDb = new Department(rs.getInt("departmentId"), rs.getString("departmentName"));
            departmentRegistry.addEntity(rs.getInt("departmentId"),departmentFromDb);
            employee.setDepartment(departmentRegistry.getEntity(rs.getInt("departmentId")));

            employees.add(employee);
        }

        return employees;
    }

    public void deleteEmployee (Integer id)  throws SQLException{
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, id);
            st.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    class Registry<T> {

        private Map<Integer, T> container = new HashMap<>();

        public T addEntity(Integer id, T entity) {
            if (!container.containsKey(id)){
                container.put(id, entity);
            }
            return this.getEntity(id);
        }

        public T getEntity(Integer id) {
            return container.get(id);
        }
    }
/** This implementation for external class

    Public class Registry<T extends Identifiable> {

        private Map<Integer, T> container = new HashMap<Integer, T>();

        public T registerEntity(T entity) {
            if (!container.containsKey(entity.getId())){
                container.put(entity.getId(), entity);
            }
            return this.getEntity(entity.getId());
        }

        public T getEntity(Integer id) {
            return container.get(entity.getId());
        }
    }

    public interface Identifiable {
        public int getId();
        public void setId(int id);
    }
 **/
}
