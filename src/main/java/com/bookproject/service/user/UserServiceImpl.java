package com.bookproject.service.user;

import com.bookproject.model.User;
import com.bookproject.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/25.
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService{
    public void add(User user) {
        this.userDaoImpl.add(user);
    }
}
