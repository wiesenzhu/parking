package com.wiesen.parking.filter;

import com.alibaba.fastjson.JSON;
import com.wiesen.parking.config.ConfigProperties;
import com.wiesen.parking.constrants.SysConstrants;
import com.wiesen.parking.vo.Response;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-12 13:14
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {
    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/parking/user/login", "register"};

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        System.out.println("filter url:" + uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if (session != null && session.getAttribute(SysConstrants.SESSION_KEY) != null) {
                // System.out.println("user:"+session.getAttribute("user"));
                UserHolder.add((UserVO)session.getAttribute(SysConstrants.SESSION_KEY));
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write(JSON.toJSONString(Response.fail(Response.login_fail, NO_LOGIN)));
                } else {
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    response.sendRedirect(request.getContextPath() + "/user/login");
                }
                return;
            }
        }
    }

    /**
     * @param uri
     * @Description: 是否需要过滤
     * @Date: 2019-04-12 13:20:54
     */
    public boolean isNeedFilter(String uri) {

        if (uri.contains("/css/") ||
                uri.contains("/imgs/") ||
                uri.contains("/js/") ||
                uri.contains("/favicon.ico")) {
            return false;
        }

        if (configProperties.getIgnoreUris().contains(uri)) {
            return false;
        }

        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
