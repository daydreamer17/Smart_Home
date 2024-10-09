package org.example.infomation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infomation.Bean.Detected;

import java.util.Map;

@Mapper
public interface DetectedMapper {
    Detected getSmokeById(@Param("idDetected") Integer idDetected);

    Detected getSoilById(@Param("idDetected") Integer idDetected);

    void insertSmokeAndSoil(@Param("data") Map<String, Integer> data);
}
