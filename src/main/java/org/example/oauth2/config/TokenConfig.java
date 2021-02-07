package org.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-01-27 14:52
 **/
@Configuration
public class TokenConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }


    /*@Bean
    public TokenStore jwtTokenStore() {

        return new JwtTokenStore(jwtAccessTokenConverter());
    }*/



    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("test_key_sing");
        return jwtAccessTokenConverter;
    }

    @Bean
    public MyJwtTokenEnhancer myJwtTokenEnhancer(){
        return new MyJwtTokenEnhancer();
    }

}
