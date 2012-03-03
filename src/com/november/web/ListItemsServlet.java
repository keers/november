package com.november.web;

import com.november.model.Item;
import com.november.model.ItemDAO;
import com.november.model.ItemDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: sergeikirsanov
 * Date: 3/2/12
 * Time: 12:29 PM
 */

@WebServlet(urlPatterns = {"/items"})
public class ListItemsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        ItemDAO itemDAO = ItemDAOImpl.getInstance();

        List<Item> items = itemDAO.getItems();


        request.setAttribute("items", items);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/items.jsp");

        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
