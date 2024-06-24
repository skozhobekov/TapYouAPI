package org.example;

import java.util.Date;

public class GetUserPOJO {
    public boolean isSuccess;
    public int errorCode;
    public Object errorMessage;
    public User user;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GetUserPOJO(boolean isSuccess, int errorCode, Object errorMessage, User user) {
        this.isSuccess = isSuccess;
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.user = user;
    }
    public GetUserPOJO() {

    }
    public static class User {

            public int id;
            public String name;
            public String gender;
            public int age;
            public String city;
            public String registrationDate;

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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public User(int id,String name, String gender, int age, String ciy, String registrationDate) {
            this.id=id;
            this.name=name;
            this.gender=gender;
            this.age=age;
            this.city=ciy;
            this.registrationDate=registrationDate;
        }
        public User() {

        }
    }
    }


