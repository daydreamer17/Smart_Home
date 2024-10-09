package org.example.infomation.Bean;

public class Windows {
    private  int idWindows;
    private boolean status;

    public Windows() {
    }

    public Windows(int idWindows, boolean status) {
        this.idWindows = idWindows;
        this.status = status;
    }

    /**
     * 获取
     * @return idWindows
     */
    public int getIdWindows() {
        return idWindows;
    }

    /**
     * 设置
     * @param idWindows
     */
    public void setIdWindows(int idWindows) {
        this.idWindows = idWindows;
    }

    /**
     * 获取
     * @return status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
