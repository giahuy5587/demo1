package vn.example.demo1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CategoryDto {
    Long id;

    @NotBlank(message = "Tên thể loại không được phép rỗng")
    @Size(min = 6, message = "Nhập ít nhất 6 ký tự!")
    String name;

    @NotBlank(message = "Mô tả thể loại không được phép rỗng")
    @Size(min = 6, message = "Nhập ít nhất 6 ký tự!")
    String description;

    List<CategoryDto> list;
}
