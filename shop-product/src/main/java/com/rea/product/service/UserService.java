package com.rea.product.service;

import com.rea.mbg.model.platform.User;

import java.util.List;

/**
 * 用户服务。
 *
 * @author tidever
 */
public interface UserService {
    /**
     * 根据用户名创建用户。
     * @param username 用户名
     * @return 用户id
     */
    long createIfAbsent(String username);

    /**
     * 注册用户并返回其id。
     * @param user 用户情报
     * @return 用户id
     */
    long register(User user);

    /**
     * 根据用户名密码登录用户。
     * @param username 用户名
     * @param password 密码
     * @return 用户情报
     */
    User login(String username, String password);

    /**
     * 根据用户id取得用户信息。
     * @param id 用户id
     * @return 用户情报
     */
    User getUser(long id);

    /**
     * 根据用户id列表取得用户信息列表。
     * @param ids 用户id列表
     * @return 用户情报列表
     */
    List<User> getUsers(List<Long> ids);

    /**
     * 获取当前登录后台用户
     * @return
     */
    User getCurrentUser();

    /**
     * 根据用户id删除用户数据。
     * @param id
     * @return
     */
    int deleteUser(long id);

    /**
     * 更新用户信息。
     * @param id
     * @param username
     * @param password
     * @return
     */
    int update(long id, String username, String password);

    /**
     * 取得所有用户信息。
     * @return
     */
    List<User> getAll();
}
