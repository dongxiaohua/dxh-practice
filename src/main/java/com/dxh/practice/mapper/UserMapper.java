package com.dxh.practice.mapper;

import cn.dxh.practice.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dongxiaohua
 */
public interface UserMapper {

  @Select("")
  UserEntity findById(@Param("id") long id);

  @Select("")
  List<UserEntity> findByAgs(@Param("age") int age);

  @Delete("")
  void deletedById(@Param("id") long id);

  @Select("")
  UserEntity findByName(@Param("name") String name);

}
