package cn.suiyi.jobcenter.executor.job;

import cn.suiyi.jobcenter.executor.service.httpService;
import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Component
public class httpWorker extends AbstractSaturnJavaJob {

    private static final Logger log = LoggerFactory.getLogger(httpWorker.class);

    @Resource
    private httpService httpService;

    @Override
    public SaturnJobReturn handleJavaJob(String jobName, Integer shardItem, String shardParam,
                                         SaturnJobExecutionContext shardingContext) throws InterruptedException {


        log.info("{} is running,item is {}, Pars {}", jobName,shardItem, shardingContext.getJobParameter());

        log.info("httpService {}", httpService);
        
        String[] kvs= StringUtils.split(shardingContext.getJobParameter(),",");

        Map<String,String> map= new HashMap<>();

        for (String kv : kvs ) {

            if(kv.contains("=")){

                int i= StringUtils.indexOf(kv,"=",0);

                String kv0 = kv.substring(0,i);
                String kv1 = kv.substring(i+1,kv.length());

                map.putIfAbsent(kv0,kv1);
            }


            
        }

        if(!map.containsKey("url")){
            return  new SaturnJobReturn(1,"url没有配置",400);
        };

        if(!map.containsKey("method")){map.put("method","get");};
        if(!map.containsKey("body")){map.put("body","");};

        try {

          String ret=   httpService.doing(map.get("url"),map.get("method"),map.get("body"),log);

            log.info("{} 执行结果 {}", jobName, ret);

            return new SaturnJobReturn(0,ret,200);
        }
        catch (Exception ex){

            log.error("{} 执行报错 {}", jobName, ex.getMessage());
            return  new SaturnJobReturn(2,ex.getMessage(),500);
        }

    }
}
