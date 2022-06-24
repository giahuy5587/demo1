package vn.example.demo1.serivce;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import vn.example.demo1.dto.ProductDto;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.entity.ProductEntity;
import vn.example.demo1.entity.UserEntity;
import vn.example.demo1.repository.ProductRepository;
import vn.example.demo1.repository.UserRepository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseListDto danhsach  (Integer page,  Integer perpage , @RequestParam(required = false) String key ) throws SQLException {
        Page<ProductEntity> pageList = productRepository.findAll(PageRequest.of(page-1,perpage));
        List<ProductEntity> data =pageList.getContent();
        Long total = pageList.getTotalElements();

        ResponseListDto  dto = new ResponseListDto();
        dto.setData(data);
        dto.setPage(page);
        dto.setTotal(total);
        dto.setNumberPage ((total%perpage==0 )? (total/perpage):(total/perpage+1));
        return dto;
    }

    public ProductDto detail(String name) {

        ProductEntity productEntity = productRepository.findFirstByName(name);
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(productEntity,dto);
        return dto;
    }


    public ProductDto detail1 (long id)
    {
        ProductEntity productEntity =productRepository.findById(id).get();
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(productEntity,dto);
        return dto;
    }




}
