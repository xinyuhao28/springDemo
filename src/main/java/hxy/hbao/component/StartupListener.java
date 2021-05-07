package hxy.hbao.component;

import hxy.hbao.tool.ZkApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Slf4j
@Component
public class StartupListener implements ApplicationContextAware, ServletContextAware,
        InitializingBean, ApplicationListener<ContextRefreshedEvent> {

    @Resource
    ZkApi zkapi;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        log.info( "1 => StartupListener.setApplicationContext" );
    }

    @Override
    public void setServletContext(ServletContext context) {
        log.info( "2 => StartupListener.setServletContext" );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info( "3 => StartupListener.afterPropertiesSet" );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        log.info( "4.1 => MyApplicationListener.onApplicationEvent" );
        if (evt.getApplicationContext().getParent() == null ) {
            log.info( "4.2 => MyApplicationListener.onApplicationEvent" );
        }
     //   zkapi.serviceRegister("regist president node");


    }


}
