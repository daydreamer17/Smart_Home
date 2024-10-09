package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.infomation.Bean.Light;

@Mapper
public interface LightMapper {
    Light getBrightnessByID(@Param("idLight") Integer idLight);



    void insertBrightness(@Param("Brightness") Integer Brightness);
}
