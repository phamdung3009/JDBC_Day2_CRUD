package org.example.ontap.jdbc2.model;

public class Student {
    private int id;
    private String name_st;
    private String clazz;
    private String phone;

    public Student() {
    }

    public Student(int id, String name_st, String clazz, String phone) {
        this.id = id;
        this.name_st = name_st;
        this.clazz = clazz;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_st() {
        return name_st;
    }

    public void setName_st(String name_st) {
        this.name_st = name_st;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name_st='" + name_st + '\'' +
                ", clazz='" + clazz + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
