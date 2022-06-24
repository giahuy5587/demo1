package vn.example.demo1.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.util.DBUtils;

import java.sql.SQLException;

@Controller
public class UserTestController {
    @GetMapping("/user/create")
    public String loadPage(){
        return  "user/create";
    }

    @PostMapping("user/create")
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) throws SQLException {
        StringBuilder sql = new  StringBuilder();
        sql.append("INSERT INTO USER (USER_NAME,PASSWORD,FULL_NAME)VALUES('");
        sql.append (userDto.getUserName()).append("','");
        sql.append (userDto.getPassword()).append("','");
        sql.append(userDto.getFullName()).append("')");
        DBUtils.create(sql.toString());
        return userDto;
    }


    @PostMapping(value = "user/create-form",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUser1(UserDto userDto, Model model) throws SQLException {
        StringBuilder sql = new  StringBuilder();
        sql.append("INSERT INTO USER (USER_NAME,PASSWORD,FULL_NAME)VALUES('");
        sql.append (userDto.getUserName()).append("','");
        sql.append (userDto.getPassword()).append("','");
        sql.append(userDto.getFullName()).append("')");
        DBUtils.create(sql.toString());
        model.addAttribute("message","Tao moi tai khoan"+userDto.getFullName()+" thanh cong ");
        return "user/create";
    }

}
