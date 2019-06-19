package cn.suiyi.jobcenter.executor;

import cn.suiyi.jobcenter.executor.job.httpWorker;
import com.vip.saturn.job.application.AbstractSaturnApplication;
import com.vip.saturn.job.springboot.GenericSpringBootSaturnApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * 简单的，继承GenericSpringBootSaturnApplication，并使用@SpringBootApplication注解该类，而且在saturn.properties中声明该类。
 *
 * <p>如果想自定义启动SpringBoot，可重写GenericSpringBootSaturnApplication的某些方法，具体可查看其javadoc。
 */
@SpringBootApplication
public class App  extends GenericSpringBootSaturnApplication {

    public static void main(String[] args)  {
        //  Thread.sleep(10*1000);
        log.info("App main");
       SpringApplication.run(App.class, args);

    }
private static final Logger log = LoggerFactory.getLogger(App.class);
    @Override
    public void init() {

        log.info("App init");
        if (applicationContext != null) {
            destroy();
        }
        applicationContext = run();
    }

    @Override
    public void destroy() {
        log.info("App destroy");
        if (applicationContext != null) {
            SpringApplication.exit(applicationContext);
            applicationContext = null;
        }
    }

    /**
     * 启动SpringBoot，默认启动方式为SpringApplication.run(source())，其中source()可查看{@link #source()}方法
     */
    @Override
    protected ApplicationContext run() {
        log.info("App run");
        return SpringApplication.run(source());
    }

    /**
     * 使用默认方式启动SpringBoot时，加载的source
     */
    @Override
    protected Object source() {
        log.info("App source");
        return this.getClass();
    }
}
