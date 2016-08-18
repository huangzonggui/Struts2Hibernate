package main.service;

import main.entity.Users;

/**
 * Created by hzg on 2016/8/18.
 */
//用户业务逻辑接口
public interface UsersDAO {
    //用户登录方法
    public boolean usersLogin(Users u);
}
