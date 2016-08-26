package test.service.impl;

import main.entity.Students;
import main.service.StudentsDAO;
import main.service.impl.StudentsDAOImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by hzg on 2016/8/19.
 */
public class TestStudentsDAOImpl {
    @Test
    public void testQueryAll() {
        StudentsDAO sdao = new StudentsDAOImpl();
        List<Students> list = sdao.queryAllStudents();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testGetNewSid() {
        StudentsDAOImpl sdao = new StudentsDAOImpl();
        System.out.println(sdao.getNewSid());
    }

    @Test
    public void testAddStudent() {
        Students s = new Students();
        s.setSname("张三更");
        s.setGender("男");
        s.setBirthday(new Date());
        s.setAddress("武当山");
        StudentsDAO sdao = new StudentsDAOImpl();
        Assert.assertEquals(true,sdao.addStudents(s));

    }
}
