package com.rick.db.mybatis.mapper;

import com.rick.db.mybatis.model.SysRole;
import com.rick.db.mybatis.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.lang.management.LockInfo;
import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper {


    @Select({"select id, user_name userName, user_password userPassword, user_email userEmail, create_time createTime, user_info userInfo, head_img headImg\n" +
            "    from sys_user where id=#{id}"})
    SysUser selectByIdZhuJie(Long id);

    @Results(id="userResultMap",value = {
            @Result(property = "id",column = "id",id=true),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "userInfo",column = "user_info"),
            @Result(property = "headImg",column = "head_img")
    })
    @Select("select * from sys_user where id=#{id}")
    SysUser selectByIdZhujie1(Long id);

    @ResultMap("userResultMap")
    @Select("select * from sys_user where id=#{id}")
    SysUser selectByIdZhujie2(Long id);

    @Insert("insert into sys_user (user_name, user_password,\n" +
            "      user_email, create_time, user_info)\n" +
            "    values (#{userName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR},\n" +
            "      #{userEmail,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{userInfo,jdbcType=LONGVARCHAR})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    int insertZhujie1(SysUser sysUser);

    @Update("update sys_user\n" +
            "    set user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      user_password = #{userPassword,jdbcType=VARCHAR},\n" +
            "      user_email = #{userEmail,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      user_info = #{userInfo,jdbcType=LONGVARCHAR},\n" +
            "      head_img = #{headImg,jdbcType=LONGVARBINARY}\n" +
            "    where id = #{id,jdbcType=BIGINT}")
    int updateZhujie1(SysUser sysUser);

    @Delete("delete from sys_user\n" +
            "    where id = #{id,jdbcType=BIGINT}")
    int deleteZhujie1(Long id);

    int deleteByPrimaryKey(Long id);


    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    List<SysRole> selectRoleByUserId(Long userId);

    /**
     *
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRoleByUserIdAndRoleEnabled(@Param("userId") Long userId,@Param("enabled") Integer enabled);

    /**
     *
     * @param userName
     * @param userEmail
     * @return
     */
    List<SysUser> selectByUser(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     *
     * @param id
     * @param userName
     * @return
     */
    SysUser selectByIdOrUserName(@Param("id") Long id,@Param("userName") String userName);

    /**
     * 根据用户 id 集合查询
     *
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 批量插入用户信息
     *
     * @param userList
     * @return
     */
    int insertList(List<SysUser> userList);

    /**
     * 通过 Map 更新列
     *
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);

    /**
     * 获取所有的用户以及对应的所有角色
     *
     * @return
     */
    List<SysUser> selectAllUserAndRoles();

    /**
     * 使用存储过程查询用户信息
     *
     * @param user
     * @return
     */
    void selectUserById(SysUser user);

    /**
     * 使用存储过程分页查询
     *
     * @param userName
     * @param pageNum
     * @param pageSize
     * @param total
     * @return
     */
    List<SysUser> selectUserPage(Map<String, Object> params);

}