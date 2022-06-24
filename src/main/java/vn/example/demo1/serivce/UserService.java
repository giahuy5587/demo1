package vn.example.demo1.serivce;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import vn.example.demo1.dto.ProductDto;
import vn.example.demo1.dto.UserDto;
import vn.example.demo1.entity.UserEntity;
import vn.example.demo1.repository.UserRepository;
import vn.example.demo1.util.DBUtils;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;




    public   UserDto saveUser (UserDto userDto) throws SQLException {

        UserEntity userEntity =userDto.conVertEntity();
        userRepository.save(userEntity);
        return userDto;


    }


    public UserDto  editUser (UserDto userDto) throws SQLException {
        UserEntity entity = userRepository.findById(userDto.getId()).get();
        if(entity==null)
        {
            System.out.println("không tồn tại user");
            throw new RuntimeException("user không tồn tại");

        }
        UserEntity userEntity =userDto.conVertEntity();
        userEntity.setPassword(entity.getPassword());
        userRepository.save(userEntity);
        return userDto;


    }



    public void  saveProduct (ProductDto productDto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PRODUCT (NAME,  PRICE, DESCRIPTION, IMAGE, CREATE_BY) VALUES ('");
        sql.append(productDto.getName()).append("','");
        sql.append(productDto.getPrice()).append("','");
        sql.append(productDto.getDescription()).append("','");
        sql.append(productDto.getImage()).append("','");
        sql.append(productDto.getCreateBy()).append("')");
        DBUtils.create(sql.toString());


    }
    public UserDto detail (long id)
    {
       UserEntity userEntity =userRepository.findById(id).get();
       UserDto dto = new UserDto();
        BeanUtils.copyProperties(userEntity,dto);
        return dto;
    }

    public ResponseListDto danhsach  (Integer page,  Integer perpage , @RequestParam(required = false) String key ) throws SQLException {
        Page<UserEntity> pageList = userRepository.findAll(PageRequest.of(page-1,perpage));
        List<UserEntity> data =pageList.getContent();
        Long total = pageList.getTotalElements();

        ResponseListDto  dto = new ResponseListDto();
        dto.setData(data);
        dto.setPage(page);
        dto.setTotal(total);
        dto.setNumberPage ((total%perpage==0 )? (total/perpage):(total/perpage+1));
        return dto;
    }

    public Optional<UserEntity> SearchById(long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> searching(String name) {

        return userRepository.findByUserNameContaining(name);
    }



    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
