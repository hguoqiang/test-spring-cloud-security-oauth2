package org.example.oauth2.service;

import org.example.oauth2.pojo.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-01-27 12:23
 **/
@Service
public class MyUserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            return new UserPo("zhangsan",passwordEncoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
