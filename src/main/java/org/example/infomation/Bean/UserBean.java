package org.example.infomation.Bean;

public class UserBean {
    private int idPERSONNEL;
    private String Name;
    private Integer Password;

    public int getId() {
        return idPERSONNEL;
    }

    public void setId(int idPERSONNEL) {
        this.idPERSONNEL = idPERSONNEL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(Integer Password) {
        this.Password = Password;
    }
}
