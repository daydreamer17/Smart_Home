package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WindowsMapper {

    void updateWindowsStatus(@Param("idWindows") int idWindows, @Param("status") int status);
}
