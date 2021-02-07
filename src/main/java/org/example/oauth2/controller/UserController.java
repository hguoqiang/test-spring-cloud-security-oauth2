package org.example.oauth2.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.example.oauth2.service.TuserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private TuserServiceImpl tuserService;

   @GetMapping("/getCurrentUser")
   public Object getCurrentUser(HttpServletRequest request,Authentication authentication) {

      String token = request.getHeader("Authorization");
      token = token.substring("Bearer".length()).trim();

      Claims claims = Jwts.parser()
              .setSigningKey("test_key_sing".getBytes(StandardCharsets.UTF_8))
              .parseClaimsJws(token)
              .getBody();

      Object enhancer = claims.get("enhancer");
      System.out.println(enhancer);

      return claims;
      //return authentication.getPrincipal();
   }

   @GetMapping("/getUserById")
   public Object getUserById(Long id){
      return tuserService.queryById(id);
   };
}