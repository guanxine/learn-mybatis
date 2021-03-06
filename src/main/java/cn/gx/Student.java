package cn.gx;

import java.io.Serializable;

/**
 * Created by guan_x on 2016/3/16.
 */
public class Student implements Serializable{
    private int id;
    private String name;
    private String branch;
    private int percentage;
    private int phone;
    private String email;

    public Student(){
        super();
    }
    public Student(String name, String branch, int percentage, int phone, String email) {
        super();
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.phone = phone;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();//线程不安全

        sb.append("Id = ").append(id).append(" - ");
        sb.append("Name = ").append(name).append(" - ");
        sb.append("Branch = ").append(branch).append(" - ");
        sb.append("Percentage = ").append(percentage).append(" - ");
        sb.append("Phone = ").append(phone).append(" - ");
        sb.append("Email = ").append(email);

        return sb.toString();
    }
}
