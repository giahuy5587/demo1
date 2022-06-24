package vn.example.demo1.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.entity.UserEntity;
import vn.example.demo1.serivce.UserService;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("backend/user")

public class BackendUserController {

    @Autowired
    UserService userService;


    @GetMapping("create")
    public String loadPageCreate() {

        return "backend/user/create";
    }

    @GetMapping("list")
    public String loadPageList(Model model, @RequestParam (defaultValue = "1")Integer page, @RequestParam (defaultValue = "5") Integer perpage ,@RequestParam(required = false) String key ) throws SQLException {

        model.addAttribute("list",userService.danhsach(page, perpage, key));
        return "backend/user/list";
    }

   

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(UserDto userDto, RedirectAttributes redirectAttributes) throws SQLException {

        userService.saveUser(userDto);

        redirectAttributes.addFlashAttribute("message", "Tạo mới tài khoản " + userDto.getFullName() + " thành công!");
        return "redirect:/backend/user/create";
    }

    @GetMapping("edit/{id}")
    public String loadPageEdit(Model model,@PathVariable  Long id) {
        model.addAttribute("user",userService.detail(id));

        return "backend/user/edit";
    }

    @PostMapping(value = "edit-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editUserForm(UserDto userDto, RedirectAttributes redirectAttributes) throws SQLException {

        userService.editUser(userDto);

        redirectAttributes.addFlashAttribute("message", "cập nhât tài khoản " + userDto.getFullName() + " thành công!");
        return "redirect:/backend/user/list";
    }


    @GetMapping("search")
    public String search (ModelMap modelMap, @RequestParam(name="name",required = false)String name)
    {
        List<UserEntity>list = null;
        if(StringUtils.hasText(name))
        {
            list =userService.searching(name);
        }
        else {
            list= userService.findAll();
        }
        modelMap.addAttribute("user",list);
        return "backend/user/search";
    }
}
