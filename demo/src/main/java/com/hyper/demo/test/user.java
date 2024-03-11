package com.hyper.demo.test;

public class user {
    private String Username;
    private Integer age;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "user [Username=" + Username + ", age=" + age + "]";
    }

    

}
