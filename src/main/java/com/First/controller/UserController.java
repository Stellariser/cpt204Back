package com.First.controller;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import com.First.pojo.User;
import com.First.service.PostService;
import com.First.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/allUser", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String list() throws JsonProcessingException {
        List<User> list = userService.listUser();

        return JSONObject.toJSONString(list);
    }

    // @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    // @ResponseBody
    // @CrossOrigin(origins = "*")
    // public String login(String username,String password) throws
    // JsonProcessingException {
    // /*String username=loginForm.getUsername();
    // String password=loginForm.getPassword();*/
    // User user = userService.queryUserByName(username);
    // Boolean result = checkLogin(username,password);
    // Map<String, Object> map = new HashMap<>();
    // Map<String,Object> loginMap = new HashMap<>();
    // if (result) {
    // map.put("status", 200);
    // map.put("msg", "登陆成功");
    // map.put("name",username);
    // }else{
    // map.put("status", 0);
    // map.put("errorInfo","登录失败，请重新登录");
    // }
    // loginMap.put("meta",map);
    // //String maps = loginMap.toString();
    //
    // return JSONObject.toJSONString(loginMap) ;
    // }
    //
    // public boolean checkLogin(String username,String password){
    // User user = userService.queryUserByName(username);
    // if (user == null || "".equals(user)){
    // return false;
    // }
    // if (user.getPassword().equals(password)){
    // return true;
    // }else {
    // return false;
    // }
    //
    //
    // }

    @RequestMapping(value = "/register", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String register(String username,String password,String answer) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> registerMap = new HashMap<>();
        if (userService.queryUserByName(username) != null) {
            registerMap.put("status", 0);
            registerMap.put("msg", "Username already exists.");
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setSecretQuestion(1);
            user.setSecretAnswer(answer);
            user.setAvator("/a");
            userService.addUser(user);
            map.put("id", userService.queryUserByName(username).getId());
            registerMap.put("data", map);
            registerMap.put("status", 200);
            registerMap.put("msg", "Register successfully.");
        }
        return JSONObject.toJSONString(registerMap);
    }

    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String login(@RequestBody Map<String, Object> loginFormMap) {
        String username = (String) loginFormMap.get("username");
        String password = (String) loginFormMap.get("password");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> loginMap = new HashMap<>();
        User userInfo = userService.queryUserByName(username);
        if (userInfo == null) {
            loginMap.put("status", 0);
            loginMap.put("msg", "Username does not exist.");
        } else if (!userInfo.getPassword().equals(password)) {
            loginMap.put("status", 1);
            loginMap.put("msg", "Password is incorrect.");
        } else {
            map.put("id", userInfo.getId());
            loginMap.put("data", map);
            loginMap.put("status", 200);
            loginMap.put("msg", "Login successfully.");
        }
        return JSONObject.toJSONString(loginMap);
    }

    // Update user avator
    @RequestMapping(value = "/updateAvator", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String updateAvator(@RequestBody Map<String, Object> updateAvatorFormMap) {
        Integer id = (Integer) updateAvatorFormMap.get("id");
        String avator = (String) updateAvatorFormMap.get("avator");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> updateAvatorMap = new HashMap<>();

        User user = userService.queryUserById(id);
        if (user == null) {
            updateAvatorMap.put("status", 0);
            updateAvatorMap.put("msg", "User does not exist.");
        } else {
            user.setAvator(avator);
            userService.updateAvator(user);
            map.put("id", user.getId());
            map.put("avator", user.getAvator());
            updateAvatorMap.put("data", map);
            updateAvatorMap.put("status", 200);
            updateAvatorMap.put("msg", "Update avator successfully.");
        }

        return JSONObject.toJSONString(updateAvatorMap);
    }

    // Update user information
    @RequestMapping(value = "/updateInfo", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String updateInfo(int id,String nickName,String gender,String grade,String major,String PersonalizedInfo) {
        String username = nickName;
        String personalInfo = PersonalizedInfo;

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> updateInfoMap = new HashMap<>();

        User user = userService.queryUserById(id);
        if (user == null) {
            updateInfoMap.put("status", 0);
            updateInfoMap.put("msg", "User does not exist.");
        }
        if(userService.queryUserByName(nickName)!=null && userService.queryUserByName(nickName).getId()!=id){
            updateInfoMap.put("status", 1);
            updateInfoMap.put("msg", "User already exists, please use another one.");
        }
        else {
            user.setUsername(username);
            user.setGender(gender);
            user.setGrade(grade);
            user.setMajor(major);
            user.setPersonalInfo(personalInfo);
            try {
                userService.updatePerosnalInfo(user);
                map.put("id", user.getId());
                map.put("username", user.getUsername());
                map.put("gender", user.getGender());
                map.put("grade", user.getGender());
                map.put("major", user.getMajor());
                map.put("personalInfo", user.getPersonalInfo());
                updateInfoMap.put("data", map);
                updateInfoMap.put("status", 200);
                updateInfoMap.put("msg", "Update info successfully.");
            } catch (DuplicateKeyException e) {
                updateInfoMap.put("status", 1);
                updateInfoMap.put("msg", "User already exists, please use another one.");
            }
        }
        return JSONObject.toJSONString(updateInfoMap);
    }

    @RequestMapping(value = "/answerCheck", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String answercheck(int id,String username,String answer) {
        User user = userService.queryUserByName(username);
        Map<String, Object> map = new HashMap<>();
        if(user.getUsername().equals(username) && user.getSecretAnswer().equals(answer)){
            map.put("status",200);
        }else {
            map.put("status",0);
        }
          return JSONObject.toJSONString(map);
    }


    // Update or reset user password
    @RequestMapping(value = "/updatePassword", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String updatePassword(int id,String password,String username) {

        //User user = userService.queryUserById(id);
        User user = userService.queryUserByName(username);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> updatePwdMap = new HashMap<>();
        if (user == null) {
            updatePwdMap.put("status", 0);
            updatePwdMap.put("msg", "User does not exist.");
        } else {
            user.setPassword(password);
            userService.updatePassword(user);
            map.put("id", user.getId());
            updatePwdMap.put("data", map);
            updatePwdMap.put("status", 200);
            updatePwdMap.put("msg", "Update password successfully.");
        }
        return JSONObject.toJSONString(updatePwdMap);
    }


    @RequestMapping(value = "/getPersonalInfo", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String getPersonalInfo(int id) {

        User user = userService.queryUserById(id);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> userInfo = new HashMap<>();
        if (user == null) {
            map.put("status", 0);
            map.put("msg", "User does not exist.");
        }
        else {
            userInfo.put("username",user.getUsername());
            userInfo.put("gender",user.getGender());
            userInfo.put("grade",user.getGrade());
            userInfo.put("major",user.getMajor());
            userInfo.put("personalInfo",user.getPersonalInfo());
            map.put("id", user.getId());
            map.put("data", userInfo);
            map.put("status", 200);
            map.put("msg", "Successful access to personal information");
        }
        return JSONObject.toJSONString(map);

    }

    @RequestMapping(value = "/getPersonalPost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String getPersonalPost(int id,int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        PostQueryInfo postQueryInfo = new PostQueryInfo();
        postQueryInfo.setPageNumber(pageNumber);
        postQueryInfo.setPageSize(pageSize);

        List<Post> post = postService.queryPostByUserId(id);
        for (Post c:post){
            String a = userService.queryUserById(c.getWriterId()).getUsername();
            c.setWriterName(a);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        for (Post c:post){
            c.setDate(c.getWrittenTime().toString().substring(0,19));
            c.setDate(sdf.format(c.getWrittenTime()));
        }
        PageInfo<Post> pageInfo = new PageInfo<>(post);



        Map<String, Object> map = new HashMap<>();
        Map<String, Object> userInfo = new HashMap<>();

        userInfo.put("postList",pageInfo.getList());
        userInfo.put("totalpage",pageInfo.getTotal());
        userInfo.put("pagenum",pageInfo.getPageNum());
        map.put("data", userInfo);
        map.put("totalpage",pageInfo.getTotal());
        map.put("status", 200);
        map.put("msg", "Successful access to personal information");

        return JSONObject.toJSONString(map);

    }
}
