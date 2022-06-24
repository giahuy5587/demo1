package vn.example.demo1.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.util.DBUtils;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HelloRestController {

    @GetMapping(value = "hello/{name}")
    public Test testController(@PathVariable String name, @RequestParam String clazz)
    {
        Test test = new Test();
        test.setClazz(clazz);
        test.setName(name);
        return test;
    }




    @GetMapping("user/list")
    public List<UserDto> layDanhsachUser(
            @RequestParam(required =false) String key,
            @RequestParam(defaultValue ="1") Integer page,
            @RequestParam(defaultValue ="3") Integer perpage
            ) throws SQLException {
        return DBUtils.danhSachUser(key,page,perpage);
    }



    @Getter
    @Setter
    @Data
    public static class Test{
        String name;
        String clazz;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }
    }
}
