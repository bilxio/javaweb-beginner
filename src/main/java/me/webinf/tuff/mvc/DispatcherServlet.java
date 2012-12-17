package me.webinf.tuff.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Bill
 * @version 2012-12-17
 */
public class DispatcherServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ctxPath = req.getContextPath() + "/app/";
        String uri = req.getRequestURI();

        if (ctxPath != null && ctxPath.length() > 0) {
            uri = uri.substring(ctxPath.length());
        }

        String method = null;

        if (uri.split("!").length > 1) {
            method = uri.split("!")[1];
            uri = uri.split("!")[0];
        }

        String controller = "demo.boardmessage." + uri + "Controller";

        try {
            Class clazz = Class.forName(controller);
            Object o = clazz.newInstance();
            Controller ctrl = (Controller)o;

            String view = null;

            if (method == null) {
                view = ctrl.action(req, resp);
            } else {
                Method actionMethod = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                view = (String)actionMethod.invoke(ctrl, req, resp);
            }

            if (view != null && view.trim().length() > 0) {
                req.getRequestDispatcher("/WEB-INF/jsp/" + view + ".jsp").forward(req, resp);
            } else {
                resp.setStatus(404);
                return;
            }
        } catch (ClassNotFoundException e) {
            resp.setStatus(404);
            return;
        } catch (InstantiationException e) {
            resp.setStatus(404);
            return;
        } catch (IllegalAccessException e) {
            resp.setStatus(404);
            return;
        } catch (NoSuchMethodException e) {
            resp.setStatus(404);
            return;
        } catch (InvocationTargetException e) {
            resp.setStatus(404);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
