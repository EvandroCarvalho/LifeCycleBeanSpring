package com.example.project.BeanPostProcessor;

import com.example.project.LiveCircle.LifeCycleBeanSpring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if( bean instanceof LifeCycleBeanSpring) {
            ((LifeCycleBeanSpring) bean).beforeInit();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleBeanSpring) {
            ((LifeCycleBeanSpring) bean).afterInit();
        }
        return bean;
    }
}
