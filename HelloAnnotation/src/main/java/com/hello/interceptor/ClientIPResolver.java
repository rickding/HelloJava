package com.hello.interceptor;

import com.hello.annotation.ClientIP;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class ClientIPResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter param) {
        return param.getParameterType().isAssignableFrom(String.class)
                && param.hasParameterAnnotation(ClientIP.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            @Nullable ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            @Nullable WebDataBinderFactory webDataBinderFactory
    ) throws Exception {
        final String param = (String) nativeWebRequest.getAttribute(ReqConstant.CLIENT_IP, RequestAttributes.SCOPE_REQUEST);
        return param == null ? "x.x.x.x" : param;
    }
}
