package org.example.infomation.Bean;

public class Camera {
    private int idCAMERA;
    private boolean Status;

    public Camera() {
    }

    public Camera(int idCAMERA, boolean Status) {
        this.idCAMERA = idCAMERA;
        this.Status = Status;
    }

    /**
     * 获取
     * @return idCAMERA
     */
    public int getIdCAMERA() {
        return idCAMERA;
    }

    /**
     * 设置
     * @param idCAMERA
     */
    public void setIdCAMERA(int idCAMERA) {
        this.idCAMERA = idCAMERA;
    }

    /**
     * 获取
     * @return Status
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * 设置
     * @param Status
     */
    public void setStatus(boolean Status) {
        this.Status = Status;
    }
}
