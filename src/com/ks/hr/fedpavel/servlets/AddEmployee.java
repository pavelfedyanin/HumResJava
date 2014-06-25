package com.ks.hr.fedpavel.servlets;

import com.ks.hr.fedpavel.db.DepartmentsDB;
import com.ks.hr.fedpavel.db.EmployeesDB;
import com.ks.hr.fedpavel.db.PositionsDB;
import com.ks.hr.fedpavel.entities.Department;
import com.ks.hr.fedpavel.entities.Employee;
import com.ks.hr.fedpavel.entities.Position;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 22.06.14.
 */
public class AddEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentsDB departmentsDB = new DepartmentsDB(con);
            List<Department> departments = departmentsDB.getAllDepartments();
            req.setAttribute("departments", departments);
            req.setAttribute("actUrl", "/employees/add");
        } catch (SQLException e) {
            throw new ServletException("Cannot load department list", e);
        }

        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PositionsDB positionsDB = new PositionsDB(con);
            List<Position> positions = positionsDB.getAllPositions();
            req.setAttribute("positions", positions);
            req.setAttribute("actUrl", "/employees/add");
        } catch (SQLException e) {
            throw new ServletException("Cannot load positions list", e);
        }

        req.getRequestDispatcher("/employees/add.jsp").include(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("actUrl", "/employees/add");
        String name = req.getParameter("name").trim();
        String birthdayStr = req.getParameter("empbirthday");
        String passport = req.getParameter("passport");

        Integer deparmentId  = Integer.parseInt(req.getParameter("departmentId").trim());//NPE - он один хуй что то передает, как такое может быть????
        Integer positionId  = Integer.parseInt(req.getParameter("positionId").trim());//NPE

        BigDecimal salary = new BigDecimal (req.getParameter("salary").trim());
        if ((!(name).equals("")) && (!(birthdayStr).equals("")) && (!(passport).equals(""))
                && (deparmentId != 0) && (positionId != 0) && (!(req.getParameter("salary").trim()).equals(""))){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = new Date() ;

            try {
                birthday = dateFormat.parse(birthdayStr);
            } catch (ParseException e) {
                System.out.println("Unparseable string " + dateFormat);
            }

            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            try {
                EmployeesDB employeesDB = new EmployeesDB(con);
                employeesDB.addEmployee(name, birthday, passport, deparmentId, positionId, salary);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", "/");
        }


        req.setAttribute("name", null);
        req.setAttribute("empbirthday", null);
        req.setAttribute("passport", null);
        req.setAttribute("departmentId", null);
        req.setAttribute("positionId", null);
        req.setAttribute("salary", null);

        getServletContext().getRequestDispatcher("/employees/add.jsp").forward(req, resp);
    }
}
