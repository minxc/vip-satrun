package cn.suiyi.jobcenter.executor;

import com.vip.saturn.job.application.AbstractSaturnApplication;
import com.vip.saturn.job.springboot.GenericSpringBootSaturnApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 简单的，继承GenericSpringBootSaturnApplication，并使用@SpringBootApplication注解该类，而且在saturn.properties中声明该类。
 *
 * <p>如果想自定义启动SpringBoot，可重写GenericSpringBootSaturnApplication的某些方法，具体可查看其javadoc。
 */
@SpringBootApplication
public class App  extends GenericSpringBootSaturnApplication {

    public static void main(String[] args)  {
        //  Thread.sleep(10*1000);
      //  SpringApplication.run(App.class, args);

    }

}
