package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testdelete() {
        CityList citylist = new CityList();
        City city = new City("Joypurhat", "Rajshahi");
        City city1 = new City("Bogura", "Bogura");
        citylist.add(city);
        citylist.add(city1);

        citylist.delete(city);
        assertTrue(!citylist.getCities().contains(city));
        assertEquals(1, citylist.getCities().size());
    }

    @Test
    public void testDeleteException() {
        CityList citylist = new CityList();
        City city = new City("Joypurhat", "Rajshahi");
        City city1 = new City("Bogura", "Bogura");
        citylist.add(city);
        citylist.add(city1);

        citylist.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            citylist.delete(city);
        });
    }

    @Test
    public void testcount(){
        CityList citylist = new CityList();
        City city = new City("Joypurhat", "Rajshahi");
        City city1 = new City("Bogura", "Bogura");

        citylist.add(city);
        citylist.add(city1);
        assertEquals(2,citylist.count());
        citylist.delete(city);
        assertEquals(1,citylist.count());
        assertEquals(citylist.count(),citylist.getCities().size());

    }

    @Test
    public void testSortByName(){
        CityList citylist = new CityList();
        City city = new City("Joypurhat", "Rajshahi");
        City city1 = new City("Bogura", "Bogura");

        citylist.add(city);
        assertEquals(0,city.compareTo(citylist.sortByName().get(0)));
        citylist.add(city1);
        assertEquals(0,city1.compareTo(citylist.sortByName().get(0)));
    }

    @Test
    public void testSortByProvince(){
        CityList citylist = new CityList();
        City city = new City("Joypurhat", "Rajshahi");
        City city1 = new City("Bogura", "Bogura");

        citylist.add(city);
        citylist.add(city1);

        assertEquals(0,city1.compareTo(citylist.sortByProvince().get(0)));

        assertEquals(0,city.compareTo(citylist.sortByProvince().get(0)));

    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


}
