package vn.example.demo1.dto;

import jdk.nashorn.internal.objects.annotations.Constructor;


import lombok.Data;
import lombok.NoArgsConstructor;
import vn.example.demo1.entity.UserEntity;

@Data



public class UserDto {
    public UserDto(Long id, String userName, String password, String fullName, String rePassword, String email, String phone, Integer gender, Integer status, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.rePassword = rePassword;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.role = role;
    }

    public UserEntity conVertEntity()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setId(id);
        userEntity.setFullName(fullName);
        userEntity.setGender(gender);
        userEntity.setRole(role);
        userEntity.setPassword(password);
        userEntity.setUserName(userName);
        return userEntity;

    }

    public UserDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String rePassword;
    private String email;
    private String phone;
    private Integer gender;
    private Integer status;
    private String role;


}