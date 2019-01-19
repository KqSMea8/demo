package com.hexin.controller;

import com.alibaba.fastjson.JSON;
import com.hexin.entity.User;
import com.hexin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //全表查询
    @RequestMapping("userList")
    @ResponseBody
    public List<User> findAll() throws Exception {
        List<User> user = userService.findAll();
        // String str = JSON.toJSONString(user);
        log.info("-----: 查询userList");
        System.out.println(user.getClass());
        return user;
    }


    //id查询
    @RequestMapping("findUserById")
    @ResponseBody
    public List<User> findUserById(@RequestParam(value = "id") Integer id) {
        List<User> user = userService.findUserById(id);
        return user;
    }

    //增加
    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser() {
        for (int i = 0; i < 10000; i++){
            User user = new User();
            user.setUsername("张二和" + "_" + i);
            user.setPassword("232323");
            user.setSex(2);
            user.setNick_name("zhangerhe");
            user.setState("1");
            Integer id = userService.insertUser(user);
        }
        return null;
    }

    //根据id删除
    @RequestMapping("delUserById")
    @ResponseBody
    public String delUserById(Integer id) {
        Integer idd = userService.delUserById(id);
        if (!StringUtils.isEmpty(idd)) {
            return "ok";
        }
        return "no";
    }

    //修改
    @RequestMapping("updateUserById")
    @ResponseBody
    public String updateUserById() {
        User user = new User();
        user.setId(24);
        user.setUsername("李四四");
        Integer id = userService.updateUserById(user);
        if (!StringUtils.isEmpty(id)) {
            return "ok";
        }
        return "no";
    }

    /**
     * .html 展示Test
     */
    @RequestMapping("viewTest")
    public String viewTest(Model model) {
        model.addAttribute("userList", userService.viewTest());
        return "userList";
    }

    public static void main(String[] args) {
        String strDate = new SimpleDateFormat("").format(new Date(System.currentTimeMillis()));
        List<String> wordList = Arrays.asList("regular", "aaaaaaaa", "cccccccccc", "as", "a", "string", "must");
        long countNumber = wordList.stream().filter(w -> w.length() > 7).count();
        System.out.println(countNumber);
        int countByIterator = 0;
        for (String word : wordList) {
            if (word.length() > 7) {
                countByIterator++;
            }
        }

        long countByStream = wordList.stream().filter(w -> w.length() > 7).count();
    }

    /**
     * 用户登陆模块测试
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public String login(String username, String password) throws Exception {
        //用户名或者密码为空
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            log.info("------------用户名或密码为空:");
        }

        // 验证用户是否存在
        User user = userService.login(username);
        if (user == null) {
            log.info("------------该用户不存在:");
        }

        // 验证用户密码
        String pwd = user.getPassword();
        if (password.equals(pwd)) {
            log.info(username + "---登陆成功");
        } else {
            log.info("------------用户密码错误:");
        }

        // 生成token
        String token = "token:";
        token += String.format(username, password, new Date());
        return token;
    }




}
