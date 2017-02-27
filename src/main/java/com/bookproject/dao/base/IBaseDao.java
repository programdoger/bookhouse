package com.bookproject.dao.base;


/**
 * Created by zmzy on 2017/2/17.
 */
public interface IBaseDao<T> {
    /**
     * 将一个对象保存到对应映射的的数据表
     * @param t
     */
    void add(T t);
}
