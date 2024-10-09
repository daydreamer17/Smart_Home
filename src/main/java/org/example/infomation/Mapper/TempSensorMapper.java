package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infomation.Bean.Temp_sensor;

import java.util.Map;

@Mapper
public interface TempSensorMapper {


    Temp_sensor getTempSensorById(@Param("idTemp") Integer idTemp);

    Temp_sensor getHumidityById(@Param("idTemp") Integer idTemp);

    void insertTemperatureAndHumidity(@Param("data") Map<String, Integer> data);

}

