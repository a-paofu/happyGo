//package com.example.config;
//
//import com.alibaba.fastjson.JSON;
//import com.example.entity.SysUser;
//import com.example.resp.ErrorCode;
//import com.example.resp.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@Component
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (!(handler instanceof HandlerMethod)) {//如果不是Controller方法,比如静态资源，直接放行
//            return true;
//        }
//        log.info("拦截器中的session：" + request.getSession());
//        SysUser user = (SysUser) request.getSession().getAttribute("USER_SESSION");
//        log.info("获取session成功？：" + user);
//
//        if (user == null) {
//            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().print(JSON.toJSONString(result));
//            return false;
//        }
//        return true;
//
//    }
//}
