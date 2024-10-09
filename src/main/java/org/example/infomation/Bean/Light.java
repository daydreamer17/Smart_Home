package org.example.infomation.Bean;

import java.util.Date;

public class Light {
    private int idLIGHT;
    private int Brightness;

    public Light() {
    }

    public Light(int idLIGHT, int Brightness) {
        this.idLIGHT = idLIGHT;
        this.Brightness = Brightness;
    }

    /**
     * 获取
     * @return idLIGHT
     */
    public int getIdLIGHT() {
        return idLIGHT;
    }

    /**
     * 设置
     * @param idLIGHT
     */
    public void setIdLIGHT(int idLIGHT) {
        this.idLIGHT = idLIGHT;
    }

    /**
     * 获取
     * @return Brightness
     */
    public int getBrightness() {
        return Brightness;
    }

    /**
     * 设置
     * @param Brightness
     */
    public void setBrightness(int Brightness) {
        this.Brightness = Brightness;
    }
}
