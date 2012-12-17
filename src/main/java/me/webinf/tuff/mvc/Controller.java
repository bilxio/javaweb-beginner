package me.webinf.tuff.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bill
 * @version 2012-12-17
 */
public interface Controller {

    public String action(HttpServletRequest req, HttpServletResponse resp);

}
