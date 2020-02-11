package com.feng.springbootftp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @create 2020-02-09-0:38
 */

public class User {

    private Integer age;
    private List<User> s= new ArrayList<>();
    private User parenteUser;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getParenteUser() {
        return parenteUser;
    }

    public void setParenteUser(User parenteUser) {
        this.parenteUser = parenteUser;
    }

    public static void main(String[] args) {
      User u =new User();
      u.setAge(111);
    }
}
