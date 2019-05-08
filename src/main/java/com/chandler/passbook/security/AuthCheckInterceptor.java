package com.chandler.passbook.security;

import com.chandler.passbook.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: ${todo}
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.TOKEN);
        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header 中缺少　"+Constants.TOKEN_STRING+"!");
        }
        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Header 中缺少　"+Constants.TOKEN_STRING+"错误!");

        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        AccessContext.clearAccessKey();
    }
}
