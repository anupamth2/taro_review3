package com.example.sql1;

public class sql1 {
    private String name;
    private  int age;
    private  boolean is_active;
    private  int id;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "sql1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", is_active=" + is_active +
                ", id=" + id +
                '}';
    }

    public sql1(String name, int age, boolean is_active, int id) {
        this.name = name;
        this.age = age;
        this.is_active = is_active;
        this.id = id;
    }

}
