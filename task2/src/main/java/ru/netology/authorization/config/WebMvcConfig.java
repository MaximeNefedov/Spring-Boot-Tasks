package ru.netology.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.authorization.model.User;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomParamResolver());
    }

    private static class CustomParamResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.getParameter().getType() == User.class;
        }

        @Override
        public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
            return new User(nativeWebRequest.getParameter("user"), nativeWebRequest.getParameter("password"));
        }
    }
}
