package org.example.oauth2.dao.generator;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.oauth2.domain.generator.TUser;
import org.example.oauth2.domain.generator.TUserExample;

import java.util.List;

@Mapper
public interface TUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @SelectProvider(type=TUserSqlProvider.class, method="countByExample")
    long countByExample(TUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @DeleteProvider(type=TUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @Insert({
        "insert into t_user (id, user_name, ",
        "password, full_name, ",
        "mobile)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{fullName,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR})"
    })
    int insert(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    int insertSelective(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @SelectProvider(type=TUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="full_name", property="fullName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    List<TUser> selectByExample(TUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @Select({
        "select",
        "id, user_name, password, full_name, mobile",
        "from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="full_name", property="fullName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    TUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @UpdateProvider(type=TUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Feb 01 18:05:38 CST 2021
     */
    @Update({
        "update t_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "full_name = #{fullName,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUser record);
}