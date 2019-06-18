package cn.suiyi.jobcenter.executor.controller;

import cn.suiyi.jobcenter.executor.job.httpWorker;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {


    @Autowired
    cn.suiyi.jobcenter.executor.job.httpWorker httpWorker;

    @RequestMapping("/test")
    public SaturnJobReturn Hello() throws InterruptedException {

        SaturnJobExecutionContext ctx = new SaturnJobExecutionContext();
        ctx.setJobParameter("url=http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ,method=get,body=");

        SaturnJobReturn ret =  httpWorker.handleJavaJob("test",0,"",ctx);
        return ret;
    }
}
