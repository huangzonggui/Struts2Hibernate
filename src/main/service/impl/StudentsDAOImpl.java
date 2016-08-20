package main.service.impl;

import main.db.MyHibernateSessionFactory;
import main.entity.Students;
import main.service.StudentsDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hzg on 2016/8/19.
 */
//学生业务逻辑接口实现类
public class StudentsDAOImpl implements StudentsDAO {

    //查询所有学生资料
    @Override
    public List<Students> queryAllStudents() {
        Transaction tx = null;
        List<Students> list = null;
        String hql;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Students";
            Query query = session.createQuery(hql);
            list = query.list();

            tx.commit();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();

            tx.commit();
            return list;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }


    @Override
    public Students queryStudentsBySid(String sid) {
        return null;
    }

    @Override
    public boolean addStudents(Students s) {
        return false;
    }

    @Override
    public boolean updateStudents(Students s) {
        return false;
    }

    @Override
    public boolean deleteStudents(String sid) {
        Transaction tx = null;

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Students s = (Students) session.get(Students.class, sid);
            session.delete(s);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.commit();
            return false;
        } finally {
            tx = null;
        }
    }
}
