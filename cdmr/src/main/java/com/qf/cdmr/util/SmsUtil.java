package com.qf.cdmr.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SmsUtil {
    public static Boolean send(String tel) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", "阳阳商城");
        request.putQueryParameter("TemplateCode", "SMS_205409285");
        Map<String,Object> map = new HashMap<>();
        String code = UUID.randomUUID().toString().substring(0,4);
        map.put("code","code");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            boolean issuccess = response.getHttpResponse().isSuccess();
            return issuccess;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
