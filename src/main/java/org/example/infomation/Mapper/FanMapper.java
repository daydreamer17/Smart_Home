package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infomation.Bean.Fan;

@Mapper
public interface FanMapper {
    void updateFanStatus(@Param("idFAN") int idFAN, @Param("status") int status);
}
