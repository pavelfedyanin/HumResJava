package com.ks.hr.fedpavel.servlets;

import com.ks.hr.fedpavel.db.DBConnection;
import com.ks.hr.fedpavel.db.DepartmentsDB;
import com.ks.hr.fedpavel.db.EmployeesDB;
import com.ks.hr.fedpavel.entities.Department;
import com.ks.hr.fedpavel.entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 22.06.14.
 */
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer departmentId;
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");

            EmployeesDB employees = new EmployeesDB(con);
            if(req.getParameter("department") != null){
                departmentId = Integer.parseInt(req.getParameter("department"));
                DepartmentsDB departments = new DepartmentsDB(con);
                Department depart = departments.getDepartmentById(departmentId);
                req.setAttribute("depart", depart);
            } else {
                departmentId = null;
            }

            List<Employee> employee = employees.getAllEmployeesByDepartmentId(departmentId);
            req.setAttribute("employee", employee);
            req.setAttribute("departmentId", departmentId);

        }catch (SQLException e){
            throw new ServletException("Cannot load employee list", e);
        }

        req.getRequestDispatcher("/index.jsp").include(req, resp);
    }
}
