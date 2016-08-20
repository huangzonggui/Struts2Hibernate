package main.action;

import main.entity.Students;
import main.service.StudentsDAO;
import main.service.impl.StudentsDAOImpl;

import java.util.List;

/**
 * Created by hzg on 2016/8/19.
 */
public class StudentsAction extends SuperAction {
    private static final long serialVersionUID = 1L;

    //查询所有学生的动作
    public String query() {
        StudentsDAO sdao = new StudentsDAOImpl();
        List<Students> list = sdao.queryAllStudents();
        //如果查询到的list不为空，则放进session中
        if (list != null && list.size() > 0) {
            session.setAttribute("students_list",list);
        }
        return "query_success";
    }

    //删除指定学生
    public String delete(){
        StudentsDAO sdao = new StudentsDAOImpl();
        String sid = request.getParameter("sid");
        sdao.deleteStudents(sid);
        return "delete_success";
    }
}
