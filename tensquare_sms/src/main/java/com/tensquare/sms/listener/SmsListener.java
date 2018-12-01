package com.tensquare.sms.listener;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.config.SmsProperties;
import com.tensquare.sms.config.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyilei
 * @date 2018/11/30-10:24
 * hello everyone
 */

@RabbitListener(queues = "sms")
@Component
@Slf4j
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {

    @Autowired
    SmsUtils smsUtils;

    @Autowired
    SmsProperties smsProperties;

    //phone code
    @RabbitHandler
    public void sendSms(Map<String,String> map){
        String phone = map.get("phone");
        String code = map.get("code");
        try {
            smsUtils.sendSms(phone,smsProperties.getSignName(),smsProperties.getVerifyCodeTemplate(),JSONObject.toJSONString(map));
        } catch (ClientException e) {
            e.printStackTrace();
            log.error("[短信发送utils执行失败]!!");
        }
    }
}
