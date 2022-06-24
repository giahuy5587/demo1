package vn.example.demo1.serivce;

import lombok.Data;
import vn.example.demo1.dto.UserDto;

import java.util.List;
@Data
public class ResponseListDto<T> {
    Integer page;
    Integer perpage;
    List<T> data;
    Long total;
    Long numberPage;

    public ResponseListDto(Integer page, Integer perpage, List<T> data, Long total, Long numberPage) {
        this.page = page;
        this.perpage = perpage;
        this.data = data;
        this.total = total;
        this.numberPage = numberPage;
    }

    public Long getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(Long numberPage) {
        this.numberPage = numberPage;
    }

    public ResponseListDto() {

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ResponseListDto(Integer page, Integer perpage, List<T> data, Long total) {
        this.page = page;
        this.perpage = perpage;
        this.data = data;
        this.total = total;

    }
}
