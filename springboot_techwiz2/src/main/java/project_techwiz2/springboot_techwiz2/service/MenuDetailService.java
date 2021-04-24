package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Menu_detail;

import java.util.List;

public interface MenuDetailService {
    List<Menu_detail> listMenuDetails();
    Menu_detail getMenuDetailById(int menu_detail_id);
    boolean saveMenu(Menu_detail menu_detail);
    boolean deleteMenu(int menu_detail_id);
    boolean updateMenu(Menu_detail menu_detail);
    Page<Menu_detail> findPaginated(int pageNo,int pageSize);
}
