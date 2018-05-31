package com.nekolr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private Logger logger = LoggerFactory.getLogger(CustomInstantiationAwareBeanPostProcessor.class.getName());

    public CustomInstantiationAwareBeanPostProcessor() {
        logger.info("调用CustomInstantiationAwareBeanPostProcessor的无参构造器实例化");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("调用InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation() beanName: " + beanName);
        // 不为null将中断后续创建bean的过程
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        logger.info("调用InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation() beanName: " + beanName);
        // 返回false将阻止其他的InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation的执行
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        logger.info("调用InstantiationAwareBeanPostProcessor.postProcessPropertyValues() 完成其他定制依赖注入和依赖检查等");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("调用InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization() beanName: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("调用InstantiationAwareBeanPostProcessor.postProcessAfterInitialization() beanName: " + beanName);
        return bean;
    }
}
