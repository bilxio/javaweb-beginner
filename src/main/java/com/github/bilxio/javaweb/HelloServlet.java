package com.github.bilxio.javaweb;

import com.github.bilxio.javaweb.db.DatabaseManager;
import com.github.bilxio.javaweb.pojo.Link;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill
 * @version 2012-12-05
 */
public class HelloServlet extends HttpServlet {

    public static final String VIEW_FILE = "/WEB-INF/jsp/hello.jsp";
    public static final String NONAME = "NONAME";
    public static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter(NAME);

        if (name == null) {
            name = NONAME;
        }

        req.setAttribute(NAME, name);

        List<Link> links = new ArrayList<Link>();
        Connection connection = null;

        try {
            connection = DatabaseManager.instance.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from hao123_link limit 0, 20");

            while (rs.next()) {
                Link link = new Link();
                link.setId(rs.getLong("id"));
                link.setName(rs.getString("name"));
                link.setUrl(rs.getString("url"));
                links.add(link);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                if (connection != null)  connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        req.setAttribute("links", links);
        req.getRequestDispatcher(VIEW_FILE).forward(req, resp);
    }

}
