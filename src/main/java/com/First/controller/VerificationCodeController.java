package com.First.controller;

import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.First.VerificationCode.VerificationCodeGenerator;
import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;

@Controller
@RequestMapping("/VerificationCode")
public class VerificationCodeController {

    @RequestMapping(value = "/get", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String getVerificationCode(int id) {

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
