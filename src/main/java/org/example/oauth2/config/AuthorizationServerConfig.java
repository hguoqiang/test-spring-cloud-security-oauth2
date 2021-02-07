package org.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * E:\BaiduNetdiskDownload\资料-Spring Security Oauth2.0认证授权专题-热门技术框架\尚学堂security\006_document\SpringSecurity.pdf
 * @description: 授权服务器配置
 * @author: huanggq
 * @create: 2021-01-27 13:56
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("myUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;


    @Qualifier("redisTokenStore")
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private MyJwtTokenEnhancer myJwtTokenEnhancer;


    @Bean
    public AuthorizationServerTokenServices authorizationServerTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        //令牌存储策略
        tokenServices.setTokenStore(tokenStore);

        //支持刷新令牌
        tokenServices.setSupportRefreshToken(true);

        //设置 令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        tokenServices.setTokenEnhancer(tokenEnhancerChain);

        tokenServices.setAccessTokenValiditySeconds(7200);//令牌默认有效期
        tokenServices.setRefreshTokenValiditySeconds(259200);//刷新令牌默认有效期3天


        return tokenServices;

    }

    /**
     * 配置客户端详情信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                //内存模式
                .inMemory()
                //配置客户端id
                .withClient("client01")
                //配置密码
                .secret(passwordEncoder.encode("123"))
                // 配置访问token的有效期
                .accessTokenValiditySeconds(3600)
                //配置刷新token的有效期
                .refreshTokenValiditySeconds(3600 * 2)
                //配置申请token后重定向的页面
                .redirectUris("http://www.baidu.com")

                //配置 申请的 权限范围
                .scopes("all")
                //配置授权类型
                .authorizedGrantTypes("authorization_code", "password","refresh_token");

    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {


        //jwtToken 增强
        TokenEnhancerChain chain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(myJwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        chain.setTokenEnhancers(delegates);

        endpoints.authenticationManager(authenticationManager)
                //配置存储令牌的策略
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)

                //.tokenServices(authorizationServerTokenServices())
                .tokenEnhancer(chain)
        ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()");
    }
}
