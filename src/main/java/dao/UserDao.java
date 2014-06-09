package dao;

import models.UserEntity;

/**
 * Created by admin on 2014. 5. 28..
 */
public interface UserDao {

    UserEntity getUser(String name);
}
