package main.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hzg on 2016/8/18.
 */
public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {
/*
* 1、为了实现action的过滤器与及拦截器功能，继承Struts2的ActionSupport是为了
* 2、为了获得内置对象实现ServletRequestAware, ServletResponseAware, ServletContextAware三个接口
* */
    private static final long serialVersionUID = 1L;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServletContext application;

    @Override
    public void setServletContext(ServletContext application) {
        //上下文
        this.application = application;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = this.request.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
