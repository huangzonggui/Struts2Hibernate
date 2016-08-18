package main.action;

import com.opensymphony.xwork2.ModelDriven;
import main.entity.Users;
import main.service.UsersDAO;
import main.service.impl.UsersDAOImpl;

/**
 * Created by hzg on 2016/8/18.
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {

    private static final long serialVersionUID = 1L;
    private Users user = new Users();

    //用户登录动作
    public String login() {
        UsersDAO udao = new UsersDAOImpl();
        //从数据库里查，看有没有这个user
        if (udao.usersLogin(user)) {
            //在session中保存登录成功的用户名，再在登录成功界面获取：欢迎${sessionScope.loginUserName}使用本系统，而${sessionScope.loginUserName}是EL的一种写法。意思是在session范围内找loginUserName，除了session还有page,application，request，
            session.setAttribute("loginUserName",user.getUsername());
            return "login_success";
        } else {
            return "login_failure";
        }
    }

    public Users getModel() {
        return this.user;
    }
}
