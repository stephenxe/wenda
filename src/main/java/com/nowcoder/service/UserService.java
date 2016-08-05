package com.nowcoder.service;

import com.nowcoder.Util.WendaUtil;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/5.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserDAO userDAO;

    public Map<String,Object> register(String username,String password){
        Map<String,Object> map =new HashMap<String,Object>();
        if (StringUtils.isBlank(username)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user!=null){
            map.put("msg","用户名已经存在");
            return map;
        }

        //密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(WendaUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);
        return map;
    }
    public User getUser(int id){
        return userDAO.selectById(id);
    }
}
