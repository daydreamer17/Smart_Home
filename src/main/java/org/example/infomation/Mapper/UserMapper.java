package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infomation.Bean.UserBean;
@Mapper
public interface UserMapper {
    UserBean findByUsernameAndPassword(@Param("name") String name, @Param("password") Integer password);
}
