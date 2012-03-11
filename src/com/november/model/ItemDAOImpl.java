package com.november.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: sergeikirsanov
 * Date: 3/2/12
 * Time: 9:42 PM
 */
public class ItemDAOImpl implements ItemDAO {
    private static ItemDAO instance = null;

    private ItemDAOImpl() {
    }

    public static synchronized ItemDAO getInstance() {
        if (instance == null) {
            instance = new ItemDAOImpl();
        }

        return instance;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/NovemberDB");


            connection = ds.getConnection();
            statement = connection.createStatement();

            resultSet = statement
                    .executeQuery("SELECT * FROM ITEMS");
            while (resultSet.next()) {

                items.add(new Item(resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("DESCRIPTION")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return items;
    }

    @Override
    public void addItem(Item item) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/sergeikirsanov/Documents/projects/november/november.sqlite");
            statement = connection.createStatement();

            System.out.println("this thread: " + Thread.currentThread().getName());


            resultSet = statement
                    .executeQuery("SELECT max(ID) maxid FROM ITEMS");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("maxid") + 1;

                item.setId(id);
            }


            Thread.currentThread().sleep(1000 * 10);


            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into ITEMS(ID, NAME, DESCRIPTION) values (?,?,?)");
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getDescription());

            preparedStatement.execute();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
