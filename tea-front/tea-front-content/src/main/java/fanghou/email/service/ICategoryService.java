package fanghou.email.service;

import fanghou.email.pojo.dto.CategoryDTO;
import fanghou.email.pojo.vo.CategoryItemVO;

import java.util.List;

public interface ICategoryService {


    List<CategoryItemVO> list();
}
