package com.example.onlineorder1.service;

import com.example.onlineorder1.dao.MenuInfoDao;
import com.example.onlineorder1.entity.MenuItem;
import com.example.onlineorder1.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {
    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants(){
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId){
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id){
        return menuInfoDao.getMesuItem(id);
    }
}
