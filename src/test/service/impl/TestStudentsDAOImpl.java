package test.service.impl;

import main.entity.Students;
import main.service.StudentsDAO;
import main.service.impl.StudentsDAOImpl;
import org.junit.Test;

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
}
