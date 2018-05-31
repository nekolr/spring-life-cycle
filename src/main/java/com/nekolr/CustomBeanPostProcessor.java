package com.nekolr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor, Ordered {

    private Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class.getName());

    public CustomBeanPostProcessor() {
        logger.info("调用CustomBeanPostProcessor的无参构造器实例化");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("调用BeanPostProcessor.postProcessBeforeInitialization() beanName: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("调用BeanPostProcessor.postProcessAfterInitialization() beanName: " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 2334;
    }
}
