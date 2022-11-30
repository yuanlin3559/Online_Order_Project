package com.example.onlineorder1.dao;

import com.example.onlineorder1.entity.MenuItem;
import com.example.onlineorder1.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {

    @Autowired
    private  SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants(){
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
            CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
            criteria.from(Restaurant.class);
            return session.createQuery(criteria).getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId){
        try(Session session = sessionFactory.openSession()){
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if(restaurant!=null){
                return restaurant.getMenuItemList();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMesuItem(int menuItemId){
        try(Session session = sessionFactory.openSession()){
            return session.get(MenuItem.class, menuItemId);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
