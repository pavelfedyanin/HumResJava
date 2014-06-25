package com.ks.hr.fedpavel.servlets;


import com.ks.hr.fedpavel.db.EmployeesDB;

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
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        EmployeesDB emDB = new EmployeesDB(con);

        try {
            emDB.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("../index").forward(req, resp);

    }
}
