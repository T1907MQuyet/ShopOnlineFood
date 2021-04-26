package project_techwiz2.springboot_techwiz2.service.Impl.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Menu_detail;
import project_techwiz2.springboot_techwiz2.repository.core.MenuDetailRepository;
import project_techwiz2.springboot_techwiz2.service.MenuDetailService;

import java.util.Date;
import java.util.List;

@Service
public class MenuDetailServiceImpl implements MenuDetailService {
    @Autowired
    private MenuDetailRepository menuDetailRepository;
    @Override
    public List<Menu_detail> listMenuDetails() {
        try {
            List<Menu_detail> list = menuDetailRepository.getAllMenuStatus();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Menu_detail getMenuDetailById(int menu_detail_id) {
        try{
            Menu_detail menu_detail = menuDetailRepository.findById(menu_detail_id).get();
            return menu_detail;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveMenu(Menu_detail menu_detail) {
        try{
            menuDetailRepository.save(menu_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMenu(int menu_detail_id) {
        try{
            Menu_detail menu_detail = menuDetailRepository.findById(menu_detail_id).get();
            menu_detail.setUpdated(new Date());
            menu_detail.setStatus(3);
            menuDetailRepository.save(menu_detail);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMenu(Menu_detail menu_detail) {
        try{
            menuDetailRepository.save(menu_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkMenuDetailName(String menuDName, int menu_id) {
        Menu_detail menu_detail = menuDetailRepository.findByMenuDetailName(menuDName,menu_id);
        if (menu_detail==null)
        {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Page<Menu_detail> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.menuDetailRepository.findPaginateMenuStatus(pageable);
    }
}
