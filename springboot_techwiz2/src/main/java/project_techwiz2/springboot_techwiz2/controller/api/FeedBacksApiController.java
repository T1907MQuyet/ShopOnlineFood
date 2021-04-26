package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.Feedbacks;
import project_techwiz2.springboot_techwiz2.repository.FeedbacksRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/feedback")
public class FeedBacksApiController {
    @Autowired
    private FeedbacksRepository feedbacksRepository;

    @RequestMapping(path = "")
    public List<Feedbacks> list()
    {
        List<Feedbacks> list = feedbacksRepository.findAll();
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public Feedbacks saveFeedBack(@Valid @RequestBody Feedbacks feedbacks)
    {
        feedbacks.setCreated(new Date());
        feedbacks.setStatus(1);
        return this.feedbacksRepository.save(feedbacks);
    }
}
