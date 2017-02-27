package com.bookproject.service.base;

import com.bookproject.dao.author.IAuthorDao;
import com.bookproject.dao.book.IBookDao;
import com.bookproject.dao.classify.IClassifyDao;
import com.bookproject.dao.comment.ICommentDao;
import com.bookproject.dao.userdao.IUserDao;
import com.bookproject.util.IUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/25.
 */
@Service
public class BaseService {
    @Autowired
    protected IAuthorDao authorDaoImpl;
    @Autowired
    protected IBookDao bookDaoImpl;
    @Autowired
    protected IClassifyDao classifyDaoImpl;
    @Autowired
    protected ICommentDao commentDaoImpl;
    @Autowired
    protected IUserDao userDaoImpl;
    @Autowired
    protected IUtil util;
}
