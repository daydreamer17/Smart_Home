package org.example.infomation.Bean;

public class Door {
    private int idDOOR;
    private boolean Status;

    public Door() {
    }

    public Door(int idDOOR, boolean Status) {
        this.idDOOR = idDOOR;
        this.Status = Status;
    }

    /**
     * 获取
     * @return idDOOR
     */
    public int getIdDOOR() {
        return idDOOR;
    }

    /**
     * 设置
     * @param idDOOR
     */
    public void setIdDOOR(int idDOOR) {
        this.idDOOR = idDOOR;
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
