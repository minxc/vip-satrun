package cn.suiyi.jobcenter.executor.service;


import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class httpService {

    private static final Logger log = LoggerFactory.getLogger(httpService.class);

    public String doing(String url, String method, String body) throws Exception {
        log.debug("httpService 参数 url={},methos={},body={}", url, method, body);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();

        if (method.trim().equalsIgnoreCase("get")) {

            Request request = new Request.Builder()
                    .url(url)
                    .get()  //默认为GET请求，可以不写
                    .build();
            final Call call = client.newCall(request);
            Response response = call.execute();
            String ret = response.body().string();
            log.debug("response={}", ret);
            return ret;
        }
        if (method.trim().equalsIgnoreCase("post")) {


            //MediaType  设置Content-Type 标头中包含的媒体类型值
            RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), body);


            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            final Call call = client.newCall(request);
            Response response = call.execute();
            String ret = response.body().string();
            log.debug("response={}", ret);
            return ret;
        }

        throw new Exception("method isnot set");

    }
}
