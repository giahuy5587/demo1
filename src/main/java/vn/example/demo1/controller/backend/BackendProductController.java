package vn.example.demo1.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.example.demo1.dto.ProductDto;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.serivce.ProductService;
import vn.example.demo1.serivce.UserService;
import vn.example.demo1.util.DBUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("backend/product")
public class BackendProductController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public static String UPLOADED_FOLDER = "C:\\Users\\Admin\\OneDrive\\Pictures\\category\\";
    @RequestMapping("create")
    public String create() {
        return "backend/product/create";
    }

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(ProductDto productDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        // @TODO Lưu productDto vào database
        redirectAttributes.addFlashAttribute("message","Tạo mới mặt hàng " + productDto.getName() + " thành công!");
        userService.saveProduct(productDto);
        return "redirect:/backend/product/create";
    }




    @PostMapping("create")
    @ResponseBody
    public ProductDto createProduct(@RequestBody ProductDto createProduct) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PRODUCT (NAME, BRAND_ID, PRICE,DESCRIPTION,CATEGORY_ID,IMAGE,CREATE_BY) VALUES ('");
        sql.append(createProduct.getName()).append("','");
        sql.append(createProduct.getId()).append("','");
        sql.append(createProduct.getPrice()).append("','");
        sql.append(createProduct.getDescription()).append("','");
        sql.append(createProduct.getCategoryId()).append("','");
        sql.append(createProduct.getImage()).append("','");
        sql.append(createProduct.getCreateBy()).append("')");
        DBUtils.create(sql.toString());
        return createProduct;
    }


    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {
        if (uploadfile.isEmpty()) {
            return null;
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfile));
        } catch (IOException e) {
            return null;
        }
        return uploadfile.getOriginalFilename();

    }

    //save file
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }

    @GetMapping("list")
    public String loadPageList(Model model, @RequestParam (defaultValue = "1")Integer page, @RequestParam (defaultValue = "5") Integer perpage , @RequestParam(required = false) String key ) throws SQLException {

        model.addAttribute("list",productService.danhsach(page, perpage, key));
        return "backend/product/list";
    }

    @GetMapping("show/{name}")
    public String loadPageEdit(Model model,@PathVariable  String name) {
        model.addAttribute("product",productService.detail(name));

        return "backend/product/show";
    }


    @GetMapping("edit/{id}")
    public String loadPageEdit(Model model,@PathVariable  Long id) {
        model.addAttribute("user",productService.detail1(id));

        return "backend/product/edit";
    }



}