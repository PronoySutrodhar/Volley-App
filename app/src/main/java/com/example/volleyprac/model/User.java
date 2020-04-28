package com.example.volleyprac.model;

public class User {
    public int id;
    public String userName;
    public String phoneno;
    public int age;
    public String emailID;

    public User(int id, String userName, String phoneNumber, int age, String email) {
        id = id;
        userName = userName;
        phoneno = phoneNumber;
        this.age = age;
        emailID = email;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        id = id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        userName = userName;
    }

    public String getphoneno() {
        return phoneno;
    }

    public void setphoneno(String phoneNumber) {
        phoneno = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getemailID() {
        return emailID;
    }

    public void setemailID(String email) {
        emailID = email;
    }

    @Override
    public String toString() {
        return
                "id=" + id + "\n" + "userName=" + userName + "\n" +
                "/n, phoneno='" + phoneno + '\'' + "\n, age=" + age + "\n, emailID='" + emailID + '\'' ;
    }
}
