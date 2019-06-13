package cn.suiyi.jobcenter.executor.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class httpService {

    private static final Logger log = LoggerFactory.getLogger(httpService.class);

    public void doing() {
        log.info("DemoService is doing...");
    }
}
