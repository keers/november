package com.november.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: sergeikirsanov
 * Date: 3/2/12
 * Time: 12:29 PM
 */

@WebServlet(urlPatterns = {"/hello"})
public class ListItemsServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        PrintWriter out = null;
        try {
            out = response.getWriter();

            out.print("Hello, NCEDU!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        DataBean b = new DataBean();

        b.setSomeOtherValue("OTHER VALUE");
        b.setSomeValue("SOME VALUE");
        DataBean b2 = new DataBean();

        b2.setSomeOtherValue("OTHER VALUE __ 2");
        b2.setSomeValue("SOME VALUE __ 2");

        List<DataBean> l = new ArrayList<DataBean>();
        l.add(b);
        l.add(b2);

        request.setAttribute("data", b);
        request.setAttribute("dataList", l);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/some.jsp");
        rd.forward(request, response);
        */
    }


}
