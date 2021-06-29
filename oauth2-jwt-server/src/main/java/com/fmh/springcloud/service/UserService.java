package com.fmh.springcloud.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private List<User> users;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        users = new ArrayList<>();
        users.add(new User("fmh", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        users.add(new User("test", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));

    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<User> findUserList = users.stream().filter(user -> user.getUsername().equals(userName)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }
}
