package com.nekolr;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class InjectBean implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(InjectBean.class.getName());

    private String name;

    private BeanFactory beanFactory;

    private String beanName;

    public InjectBean() {
        logger.info("调用InjectBean的无参构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("注入属性name: " + name);
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        logger.info("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    @Override
    public void destroy() {
        logger.info("调用DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() {
        logger.info("调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * 自定义初始化方法，对应<bean>的init-method属性
     */
    public void customInit() {
        logger.info("调用<bean>的init-method属性指定的初始化方法");
    }

    /**
     * 自定义的销毁方法，对应<bean>的destroy-method属性指定的销毁方法
     */
    public void customDestroy() {
        logger.info("调用<bean>的destroy-method属性指定的销毁方法");
    }

    @Override
    public String toString() {
        return "InjectBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
