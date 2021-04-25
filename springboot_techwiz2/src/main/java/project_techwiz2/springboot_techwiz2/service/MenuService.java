package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> lisMenus();
    Menu getMenyById(int menu_id);
    List<Menu> listMenuByStatus(int status);
    boolean saveMenu(Menu menu);
    boolean updateMenu(Menu menu);
    boolean deleteMenu(int menu_id);
    Page<Menu> findPaginated(int pageNo,int pageSize);
}
