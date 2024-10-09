package org.example.infomation.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infomation.Bean.Door;

@Mapper
public interface DoorMapper {
    Door getDoorById(@Param("idDoor") Integer idDoor);


    void updateDoorStatus(@Param("idDOOR") int idDOOR, @Param("status") int status);
}

