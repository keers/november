package com.november.web;

import com.november.model.Item;
import com.november.model.ItemDAO;
import com.november.model.ItemDAOImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: sergeikirsanov
 * Date: 3/2/12
 * Time: 10:18 PM
 */

@WebServlet(urlPatterns = {"/add_item"})
public class AddItemServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        ItemDAO itemDAO = ItemDAOImpl.getInstance();

        String name = req.getParameter("name");
        String description = req.getParameter("description");

        Item item = new Item(name, description);

        
        System.out.println(name);
        System.out.println(description);

        itemDAO.addItem(item);

        try {
            res.sendRedirect("items");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//       doPost(req, res);
    }
}
