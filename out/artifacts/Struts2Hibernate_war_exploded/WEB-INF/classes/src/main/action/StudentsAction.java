package main.action;

import main.entity.Students;
import main.service.StudentsDAO;
import main.service.impl.StudentsDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    //添加学生
    public String add() throws Exception {
        Students s = new Students();
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        s.setBirthday(sdf.parse(request.getParameter("birthday")));
        s.setAddress(request.getParameter("address"));
        StudentsDAO sdao=new StudentsDAOImpl();
        sdao.addStudents(s);
        return "add_success";
    }

    //修改学生资料动作
    public String modify() {
        //获得传递过来的学生编号
        String sid = request.getParameter("sid");
        StudentsDAO sdao = new StudentsDAOImpl();
        Students s = sdao.queryStudentsBySid(sid);
        //保存在会话中
        session.setAttribute("modify_students",s);
        return "modify_success";
    }

    //保存修改后的学生资料
    public String save() throws ParseException {
        Students s = new Students();
        s.setSid(request.getParameter("sid"));
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        s.setBirthday(sdf.parse(request.getParameter("birthday")));
        s.setAddress(request.getParameter("address"));
        StudentsDAO sdao=new StudentsDAOImpl();
        sdao.updateStudents(s);
        return "save_success";

    }

}
