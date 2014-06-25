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

/**
 * Created by Pavel on 22.06.14.
 */
public class AddDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("departmentName", "");
        req.setAttribute("departmentId", null);
        req.setAttribute("actURL", "/departments/add");

        req.getRequestDispatcher("/departments/add.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("departmentName").trim();
        //Integer id = Integer.parseInt(req.getParameter("departmentId").trim());

        if (!name.equals("")) {
            //Department department = null;
            Department department = new Department(name);
            /**
             * if (id !=0){
             * department = new Department(id, name);
             * }else{
             *   department = new Department(name);
             * }
             */

            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentsDB dpDB = new DepartmentsDB(con);
            try {
                dpDB.saveDepartmentToDB(department);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("This department has not been saved - "+department);
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", "/");
        }
        //req.setAttribute("departmentName", name);
        req.setAttribute("departmentName", null);
        req.setAttribute("actUrl", "/departments/add");
        getServletContext().getRequestDispatcher("/departments/add.jsp").forward(req, resp);
    }

}
