package org.example.infomation.Bean;

public class Detected {
    private int idDetected;
    private int smoke_value;
    private int soil_value;

    public Detected() {
    }

    public Detected(int idDetected, int smoke_value, int soil_value) {
        this.idDetected = idDetected;
        this.smoke_value = smoke_value;
        this.soil_value = soil_value;
    }

    /**
     * 获取
     * @return idDetected
     */
    public int getIdDetected() {
        return idDetected;
    }

    /**
     * 设置
     * @param idDetected
     */
    public void setIdDetected(int idDetected) {
        this.idDetected = idDetected;
    }

    /**
     * 获取
     * @return smoke_value
     */
    public int getSmoke_value() {
        return smoke_value;
    }

    /**
     * 设置
     * @param smoke_value
     */
    public void setSmoke_value(int smoke_value) {
        this.smoke_value = smoke_value;
    }

    /**
     * 获取
     * @return soil_value
     */
    public int getSoil_value() {
        return soil_value;
    }

    /**
     * 设置
     * @param soil_value
     */
    public void setSoil_value(int soil_value) {
        this.soil_value = soil_value;
    }
}

