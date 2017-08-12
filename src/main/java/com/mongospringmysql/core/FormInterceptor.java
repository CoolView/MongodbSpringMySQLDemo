package com.mongospringmysql.core;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 防止表单 重复提交 
 * 使用方法： 
 * 	1，在spring-mvc.xml文件中，找到拦截器配置，加入 需要防止表单重复提交的url 
 * 	2，在界面中加入
 * 	<input type="hidden" name="token" value="${token}">
 * 
 * @author bin
 * 
 */
public class FormInterceptor implements HandlerInterceptor {

	// 在业务处理器处理请求之前被调用
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// POST, PUT, DELETE 请求都有可能是表单提交
        if (!"GET".equalsIgnoreCase(request.getMethod())) {
            String clientToken = request.getParameter("token");//界面传入token
            String serverToken = (String) request.getSession().getAttribute(clientToken);//session中的token
            if (clientToken == null || clientToken.isEmpty() || !clientToken.equals(serverToken)) {
            	//throw new RuntimeException("重复提交表单");
            	request.setAttribute("fromErrorInfo", "您的请求正在处理中，请勿重复提交。");
            	request.getRequestDispatcher("/briefreport/errorInfo.do").forward(request, response);
            	return false;
            }

            // 正常提交表单，删除 token
            request.getSession().removeAttribute(clientToken);
        }
		
		return true;
	}

	// 在DispatcherServlet完全处理完请求后被调用
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 在业务处理器处理请求之后被调用
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,  ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		// GET 请求访问表单页面
        if (!"GET".equalsIgnoreCase(request.getMethod())) {
            return;
        }

        // 生成 token 存储到 session 里，并且保存到 form 的 input 域
        String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        modelAndView.addObject("token", token);//创建界面token
        request.getSession().setAttribute(token, token);
	}
}
