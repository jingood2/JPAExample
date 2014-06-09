package dao.impl;

import dao.UserDao;
import models.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by admin on 2014. 5. 28..
 */
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public UserEntity getUser(String name) {

       List<UserEntity> userList =  em.createQuery("From UserEntity as user WHERE user.name = :name",UserEntity.class).setParameter("name", name).getResultList();

       if(userList.isEmpty())
           return null;

       return userList.get(0);
    }
}
