package org.example.oauth2.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-02-01 11:20
 **/
@Data
@ToString
public class Tuser {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
