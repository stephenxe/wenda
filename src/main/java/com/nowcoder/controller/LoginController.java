package com.nowcoder.controller;

import com.nowcoder.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/5.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/reg"},method = {RequestMethod.POST,RequestMethod.GET})
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password){
        try {
            Map<String,Object> map = userService.register(username, password);
            if (!map.containsKey("msg")){
                return "redirect:/";
            }
            model.addAttribute("msg",map.get("msg"));
            return "login";
        } catch (Exception e) {
            logger.error("注册异常" + e.getMessage());
            return "login";
        }
    }
    @RequestMapping(path = {"/reglogin"},method = {RequestMethod.POST,RequestMethod.GET})
    public String regloginPage(Model model){
        return "login";
    }


}
