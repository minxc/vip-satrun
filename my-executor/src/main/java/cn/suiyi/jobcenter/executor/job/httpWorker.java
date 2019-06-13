package cn.suiyi.jobcenter.executor.job;

import cn.suiyi.jobcenter.executor.service.httpService;
import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class httpWorker extends AbstractSaturnJavaJob {

    private static final Logger log = LoggerFactory.getLogger(httpWorker.class);

    @Resource
    private httpService httpService;

    @Override
    public SaturnJobReturn handleJavaJob(String jobName, Integer shardItem, String shardParam,
                                         SaturnJobExecutionContext shardingContext) throws InterruptedException {

        log.info("{} is running, item is {}", jobName, shardItem);
        log.info("{} is running, Pars {}", jobName, shardingContext.getJobParameter());
       // httpService.doing();
        return new SaturnJobReturn();
    }
}
