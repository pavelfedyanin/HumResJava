package com.ks.hr.fedpavel.listeners;

import com.ks.hr.fedpavel.db.DBConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.File;

/**
 * Created by Pavel on 25.06.14.
 */

@WebListener
public class AppCxtListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {


        ServletContext ctx = servletContextEvent.getServletContext();

        String databaseURL = ctx.getInitParameter("databaseURL");
        String user = ctx.getInitParameter("user");
        String password = ctx.getInitParameter("password");

        try {
            DBConnection connectionManager = new DBConnection(databaseURL, user, password);
            ctx.setAttribute("DBConnection", connectionManager.getConnection());
            System.out.println("DB Connection is established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
