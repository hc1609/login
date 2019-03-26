package com.hysz.login.mapper;

import com.hysz.login.model.UserRoles;
import com.hysz.login.model.UserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRolesMapper {
    long countByExample(UserRolesExample example);

    int deleteByExample(UserRolesExample example);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);
    
    UserRoles selectByAccount(@Param("account")String account);

    int updateByExampleSelective(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    int updateByExample(@Param("record") UserRoles record, @Param("example") UserRolesExample example);
}