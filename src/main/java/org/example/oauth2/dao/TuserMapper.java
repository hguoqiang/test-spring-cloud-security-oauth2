package org.example.oauth2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.oauth2.pojo.Tuser;
import org.example.oauth2.pojo.TuserParam;
import org.example.oauth2.pojo.TuserResult;

import java.util.List;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-02-01 11:28
 **/
@Mapper
public interface TuserMapper {

    @Select("select id,user_name,password,full_name,mobile from t_user where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_name", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "full_name", property = "fullname"),
            @Result(column = "mobile", property = "mobile")
    })
    Tuser selectByPrimaryKey(Long id);

    @Select("<script>" +
            "select id,user_name,password,full_name,mobile from t_user" +
            "<where> " +
            "<if test= \" id !=null and id !='' \"> AND id = #{id} </if>" +
            "<if test= \" mobile !=null and mobile !='' \">AND mobile = #{mobile} </if> " +

            "</where>" +
            "</script>")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_name", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "full_name", property = "fullname"),
            @Result(column = "mobile", property = "mobile")
    })
    List<TuserResult> selectList(TuserParam param);


}
