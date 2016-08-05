package com.nowcoder.service;

import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/5.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public User getUser(int id){
        return userDAO.selectById(id);
    }
}
