package org.example.infomation.Bean;

public class Fan {
    private int idFAN;
    private boolean Status;

    public Fan() {
    }

    public Fan(int idFAN, boolean Status) {
        this.idFAN = idFAN;
        this.Status = Status;
    }

    /**
     * 获取
     * @return idFAN
     */
    public int getIdFAN() {
        return idFAN;
    }

    /**
     * 设置
     * @param idFAN
     */
    public void setIdFAN(int idFAN) {
        this.idFAN = idFAN;
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
