## Spring bean生命周期图
![Spring bean生命周期](https://github.com/nekolr/spring-life-cycle/blob/master/Spring%20bean%E7%9A%84%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F.png)

- The full set of initialization methods and their standard order is  
  1. BeanNameAware's setBeanName
  2. BeanClassLoaderAware's setBeanClassLoader
  3. BeanFactoryAware's setBeanFactory
  4. EnvironmentAware's setEnvironment
  5. EmbeddedValueResolverAware's setEmbeddedValueResolver
  6. ResourceLoaderAware's setResourceLoader (only applicable when running in an application context)
  7. ApplicationEventPublisherAware's setApplicationEventPublisher (only applicable when running in an application context)
  8. MessageSourceAware's setMessageSource (only applicable when running in an application context)
  9. ApplicationContextAware's setApplicationContext (only applicable when running in an application context)
  10. ServletContextAware's setServletContext (only applicable when running in a web application context)
  11. postProcessBeforeInitialization methods of BeanPostProcessors
  12. InitializingBean's afterPropertiesSet
  13. a custom init-method definition
  14. postProcessAfterInitialization methods of BeanPostProcessors
  
- On shutdown of a bean factory, the following lifecycle methods apply
  1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors
  2. DisposableBean's destroy
  3. a custom destroy-method definition

## Spring IoC容器剖析

[Spring IoC容器剖析](https://blog.nekolr.com/2018/05/27/Spring%20IoC%20%E5%AE%B9%E5%99%A8%E5%89%96%E6%9E%90/)
