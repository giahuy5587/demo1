package vn.example.demo1.controller.backend;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.example.demo1.dto.CategoryDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("backend/category")
public class BackendCategorycontroller {

    @RequestMapping("create")
    public String create(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "backend/category/create";
    }

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(@ModelAttribute(name = "category") @Valid CategoryDto category, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        // @TODO Lưu productDto vào database
        if (bindingResult.hasErrors()) {
            return "backend/category/create";
        }
        return "redirect:/backend/category/create";
    }
}
