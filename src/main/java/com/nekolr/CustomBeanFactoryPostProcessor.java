package com.nekolr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanFactoryPostProcessor implements org.springframework.beans.factory.config.BeanFactoryPostProcessor {

    private Logger logger = LoggerFactory.getLogger(CustomBeanFactoryPostProcessor.class.getName());

    public CustomBeanFactoryPostProcessor() {
        logger.info("调用CustomBeanFactoryPostProcessor的无参构造器实例化");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("调用BeanFactoryPostProcessor.postProcessBeanFactory()");
    }
}
