package org.example.infomation.Bean;

public class Temp_sensor {
    private int idTEMP_SENSOR;
    private int Current_Temp;

    private int humidity;


    public Temp_sensor() {
    }

    public Temp_sensor(int idTEMP_SENSOR, int Current_Temp, int humidity) {
        this.idTEMP_SENSOR = idTEMP_SENSOR;
        this.Current_Temp = Current_Temp;
        this.humidity = humidity;
    }

    /**
     * 获取
     * @return idTEMP_SENSOR
     */
    public int getIdTEMP_SENSOR() {
        return idTEMP_SENSOR;
    }

    /**
     * 设置
     * @param idTEMP_SENSOR
     */
    public void setIdTEMP_SENSOR(int idTEMP_SENSOR) {
        this.idTEMP_SENSOR = idTEMP_SENSOR;
    }

    /**
     * 获取
     * @return Current_Temp
     */
    public int getCurrent_Temp() {
        return Current_Temp;
    }

    /**
     * 设置
     * @param Current_Temp
     */
    public void setCurrent_Temp(int Current_Temp) {
        this.Current_Temp = Current_Temp;
    }

    /**
     * 获取
     * @return humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * 设置
     * @param humidity
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
