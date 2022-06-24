package vn.example.demo1.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.example.demo1.dto.CategoryDto;
import vn.example.demo1.dto.ProductDto;
import vn.example.demo1.dto.ResponseDto;
import vn.example.demo1.serivce.ProductService;
import vn.example.demo1.serivce.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
@Controller
public class HomeController {

    @Autowired
    UserService userService;





    @RequestMapping({"/", "home","home/page", "home/page/1"})
    public String homepage(Model model){
        model.addAttribute("danhsachCategory", new ArrayList<CategoryDto>());// lấy từ db
        return "home";
    }

    // Lấy danh sản phẩm theo category id
    @RequestMapping("category/{id}")
    public String category(Model model, @PathVariable Long id){
        // Query trong db sác sản phẩm có category id = {id}
        model.addAttribute("danhsachProduct", new ArrayList<ProductDto>());// lấy từ db
        return "homecategory";
    }

    @RequestMapping("/pages/about-us")
    public String homepage(){

        return "home1";
    }

    @RequestMapping("/blogs/news")
    public String homepage1(){

        return "home2";
    }


    @RequestMapping("/pages/the-khach-hang-fresh-garden")
    public String homepage2(){

        return "home3";
    }


    @RequestMapping("/pages/he-thong-cua-hang")
    public String homepage3(){

        return "home4";
    }


    @RequestMapping("/pages/lien-he")
    public String homepage4(){

        return "home5";
    }

    @RequestMapping("/blogs/tuyen-dung")
    public String homepage5(){

        return "home6";
    }







}
