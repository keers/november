package com.november.model;

import java.util.List;

/**
 * User: sergeikirsanov
 * Date: 3/2/12
 * Time: 9:42 PM
 */
public interface ItemDAO {

    public List<Item> getItems();
    
    public void addItem(Item item);

}
