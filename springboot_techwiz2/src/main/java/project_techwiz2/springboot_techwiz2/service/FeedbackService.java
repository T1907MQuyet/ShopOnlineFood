package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.Feedbacks;

import java.util.List;

public interface FeedbackService {
    List<Feedbacks> listFeedback();
    Feedbacks getFbById(int id);
    Page<Feedbacks> findPaginated(int pageNo, int pageSize);
    boolean update(int id);

}
