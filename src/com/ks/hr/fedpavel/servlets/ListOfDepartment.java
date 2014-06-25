package com.ks.hr.fedpavel.servlets;

import com.ks.hr.fedpavel.db.DBConnection;
import com.ks.hr.fedpavel.db.DepartmentsDB;
import com.ks.hr.fedpavel.entities.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by Pavel on 23.06.14.
 */
public class ListOfDepartment extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentsDB departments = new DepartmentsDB(con);
            List<Department> department = departments.getAllDepartments();
            req.setAttribute("department", department);
        } catch (SQLException e) {
            throw new ServletException("Cannot load department list", e);
        }

        String departParam = req.getParameter("department");
        if(departParam != null){
            req.setAttribute("departParam", Integer.parseInt(departParam));
        }

        req.getRequestDispatcher("/elements/departments.jsp").include(req, resp);
    }
}
