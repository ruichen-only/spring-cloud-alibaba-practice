package com.tidever.platform.service.impl;

import com.tidever.common.service.RedisService;
import com.tidever.mbg.mapper.platform.UserMapper;
import com.tidever.mbg.model.platform.User;
import com.tidever.mbg.model.platform.UserExample;
import com.tidever.platform.service.UserService;
import com.tidever.search.service.EsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private RedisService redisService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private EsUserService esUserService;

    @Override
    public long createIfAbsent(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(genRandomPwd());
            userMapper.insertSelective(user);

            return user.getId();
        } else {
            return users.get(0).getId();
        }
    }

    /**
     * 生成随机密码。
     * @return 随机生成的密码
     */
    private String genRandomPwd() {
        byte[] bs = new byte[15];

        SecureRandom sr = new SecureRandom();
        sr.nextBytes(bs);

        return new String(bs, StandardCharsets.ISO_8859_1);
    }

    @Override
    public long register(User user) {
        //查询是否有相同用户名的用户
        UserExample example = new UserExample();
        example.createCriteria()
               .andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if(users.isEmpty()) {
            //TODO 密码加密
            userMapper.insert(user);
            Long id = user.getId();
            esUserService.create(id);
            return id;
        }
        return -1;
    }

    @Override
    public User login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                   .andUsernameEqualTo(username)
                   .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User getUser(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUsers(List<Long> ids) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(ids);

        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getCurrentUser() {
        HttpSession session = request.getSession();
//        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
//        if(StrUtil.isEmpty(userStr)){
//            Asserts.fail(ResultCode.UNAUTHORIZED);
//        }
//        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
//        UmsAdmin admin = adminCacheService.getAdmin(userDto.getId());
//        if(admin!=null){
//            return admin;
//        }else{
//            admin = adminMapper.selectByPrimaryKey(userDto.getId());
//            adminCacheService.setAdmin(admin);
//            return admin;
//        }
        return null;
    }

    @Override
    public int deleteUser(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(long id, String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserExample example = new UserExample();
        example.createCriteria()
               .andIdEqualTo(id);
        return userMapper.updateByExample(user, example);
    }

    @Override
    public List<User> getAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }
}
