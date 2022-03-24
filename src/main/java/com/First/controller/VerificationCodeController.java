package com.First.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.First.VerificationCode.VerificationCodeGenerator;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @GetMapping(value = "getVerificationCode")
    public String getVerificationCode() {

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> verificationCodeMap = new HashMap<>();

        try {
            map = VerificationCodeGenerator.generateCode();
        } catch (IOException e) {
            verificationCodeMap.put("status", 0);
            verificationCodeMap.put("msg", "Failed to generate a verification code.");
            return JSONObject.toJSONString(verificationCodeMap);
        }

        verificationCodeMap.put("status", 200);
        verificationCodeMap.put("msg", "Verification code generated successfully.");
        verificationCodeMap.put("data", map);

        return JSONObject.toJSONString(verificationCodeMap);
    }

}
