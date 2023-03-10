package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * adds a city to the list
     * check if the list has the city we just added
     */
    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        assertEquals(1,
                list.hasCity(city));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        City city2 = new City("Edmonton", "Alberta");
        City city3 = new City("Toronto", "Ontario");
        list.addCity(city);
        list.addCity(city2);
        list.addCity(city3);
        assertEquals(list.getCount(),3);
        list.delete(city2);
        assertEquals(2, list.getCount());
        assertEquals(0, list.hasCity(city2));
        list.delete(city3);
        assertEquals(1, list.getCount());
        assertEquals(0, list.hasCity(city3));
    }



}
