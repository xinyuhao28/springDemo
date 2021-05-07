package hxy.hbao.interceptor;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInInterceptor implements HandlerInterceptor {
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("LogInInitializer.preHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        System.out.println("LogInInitializer.preHandle end");
        String strVal = request.getParameter("name");
        System.out.println("strVal = " + strVal);
        if(strVal.equals("hao")){
            return true;
        }
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView)  {
        //
        System.out.println("LogInInitializer.postHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", modelAndView = " + modelAndView);
        System.out.println("controller 执行完了");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("我获取到了一个返回的结果："+response);
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", ex = " + ex);

        System.out.println("请求结束了");
    }
}
