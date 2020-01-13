package com.example.project.LiveCircle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
public class LifeCycleBeanSpring implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    //  1
    public LifeCycleBeanSpring() {
        log.info("### I'am in the lifeCycleBean Constructor");
    }

    //  9
    @Override
    public void destroy() throws Exception {
        log.info("### The Lifecycle bean has been terminated");
    }

    //  6
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("### The LifecycleBean has its properties set!");
    }

    //  3
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("### Bean Factory has been set");
    }

    //  2
    @Override
    public void setBeanName(String name) {
        log.info("### My Bean Name is: {}", name);
    }

    //  4
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("### Application context has been set");
    }

    //  6
    @PostConstruct
    public void postConstructor() {
        log.info("### The Post Constructor annotated method has been called");
    }

    //  8
    @PreDestroy
    public void preDestroy() {
        log.info("### The Pre Destroy annotated method has been called");
    }

    //  5
    public void beforeInit() {
        log.info("### Before init - Called by bean Post Processor");
    }

    //  7
    public void afterInit() {
        log.info("### After init called by Bean Post Processor");
    }

}
