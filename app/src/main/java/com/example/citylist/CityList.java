package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city to the list if that city exists
     * @param city
     * This is the city to delete
     */
    public void delete(City city) {
        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns the size of the cities
     * @return
     *      Return the size of the city
     */

    public int count(){
        return cities.size();
    }
    /**
     * This sorts a list by city name
     * @param
     */

    public List<City> sortByName(){
        //Collections.sort(cities);
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     *This sorts a list by Province name
     * @param
     */

    public List<City> sortByProvince(){

        List<City> cityList = cities;
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City city, City t1) {
                return city.getProvinceName().compareTo(t1.getProvinceName());
            }
        });

        return cityList;
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }
}
