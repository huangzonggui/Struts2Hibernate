package main.action;

import com.opensymphony.xwork2.ModelDriven;
import main.entity.Users;
import main.service.UsersDAO;
import main.service.impl.UsersDAOImpl;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
            session.setAttribute("loginUserName", user.getUsername());
            return "login_success";
        } else {
            return "login_failure";
        }
    }

    //用户登录动作(因为validate方法对这个action中的所有方法都有效，但是注销无需经过validate检测)
    @SkipValidation
    public String logout() {
        if (session.getAttribute("loginUsername") != null) {
            session.removeAttribute("loginUsername");
        }
        return "logout_success";
    }

    @Override
    public void validate() {
        if ("".equals(user.getUsername().trim())) {
            this.addFieldError("usernameError", "用户名不能为空");
        }
        if (user.getPassword().length() < 6) {
            this.addFieldError("passwordError", "密码长度不少于6位");
        }
    }


    public Users getModel() {
        return this.user;
    }
}
