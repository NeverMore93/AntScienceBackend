package com.as.backend.antscience.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.asynchttpclient.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SMSHttpRequest {
    private String appid;
    private String to;
    private String project;
    private String signature;
    private String URL;

    public void excute() {
        String code = RandomCode.generateCode(4);
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        List<Param> params = new ArrayList<Param>();
        params.add(new Param("appid", appid));
        params.add(new Param("to", to));
        params.add(new Param("project", project));
        params.add(new Param("signature", signature));
        params.add(new Param("vars", "{\"code\":\"" + code + "\"}"));
        Request request = asyncHttpClient.preparePost("https://api.mysubmail.com/message/xsend.json").setFormParams(params).build();

        ListenableFuture<Integer> f = asyncHttpClient.executeRequest(request, new AsyncCompletionHandler<Integer>() {
            @Override
            public Integer onCompleted(Response response) throws Exception {
                System.out.println(response.getStatusCode());
                return response.getStatusCode();
            }
            @Override
            public void onThrowable(Throwable t) {

            }
        });
        if (f != null) {
            try {
                int statusCode = f.get();
                System.out.println(statusCode);
            } catch (InterruptedException | ExecutionException ex) {

            }
        }
        asyncHttpClient.close();



    }}
