package main.service.impl;

import main.db.MyHibernateSessionFactory;
import main.entity.Users;
import main.service.UsersDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hzg on 2016/8/18.
 */
public class UsersDAOImpl implements UsersDAO {
    @Override
    public boolean usersLogin(Users u) {
        //事务对象
        Transaction tx = null;
        String hql = "";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();//开启事务
            hql = "from Users where username=? and password=? ";
            Query query = session.createQuery(hql);
            query.setParameter(0, u.getUsername());
            query.setParameter(1, u.getPassword());
            List list = query.list();
            tx.commit();//提交事务
//            System.out.println(list.toString());
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }finally {
            if (tx != null) {
                tx = null;
            }
        }
    }
}
