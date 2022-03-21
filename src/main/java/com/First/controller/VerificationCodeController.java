package com.First.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.VerificationCode.CodeImage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @GetMapping(value = "getVC")
    public String getVerificationCode() {

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> vcMap = new HashMap<>();

        try {
            map = CodeImage.generateCode();
        } catch (IOException e) {
            vcMap.put("status", 0);
            vcMap.put("msg", "Failed to generate a verification code.");
            return JSONObject.toJSONString(vcMap);
        }

        vcMap.put("status", 200);
        vcMap.put("msg", "Verification code generated successfully.");
        vcMap.put("data", map);

        return JSONObject.toJSONString(vcMap);
    }

}
