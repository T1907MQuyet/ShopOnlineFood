package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.About_us;

import java.util.List;

public interface AboutUsService {
    List<About_us> listAboutUs();
    About_us getAboutById(int id);
    boolean saveAbout(About_us about_us);
    boolean updateAbout(About_us about_us);
    boolean deleteAbout(int id);
    Page<About_us> findPaginated(int pageNo,int pageSize);
}
