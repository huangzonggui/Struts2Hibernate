package test.service.impl;

import main.entity.Users;
import main.service.UsersDAO;
import main.service.impl.UsersDAOImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzg on 2016/8/18.
 */
public class TestUsersDAOImpl {
    @Test
    public void testUsersLogin(){
        Users u = new Users(1, "zhangsan", "123456");
        //用接口类型UsersDAO，体现多态性？？？？
        UsersDAO udao = new UsersDAOImpl();
        Assert.assertEquals(true,udao.usersLogin(u));
    }
}
