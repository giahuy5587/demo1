package vn.example.demo1.dto;

import lombok.Data;
import vn.example.demo1.entity.ProductEntity;
import vn.example.demo1.entity.UserEntity;

@Data
public class ProductDto {
   private Long id;
    private String name;
    private  String description;
    private  Double price;
    private  String brandId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    private  Long categoryId;
    private  String image;
    private  String createBy;

    public ProductEntity conVertEntity1()
    {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(id);
        productEntity.setName(name);
        productEntity.setDescription(description);
        productEntity.setPrice(price);
        productEntity.setBrandId(brandId);
        productEntity.setCategoryId(categoryId);
        productEntity.setImage(image);
        productEntity.setCreateBy(createBy);

        return productEntity;

    }

}