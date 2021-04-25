package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.repository.core.CategoryDetailRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/categoryDetail")
public class CategoryDetailApiController {
    @Autowired
    private CategoryDetailRepository categoryDetailRepository;

    @RequestMapping(path = "")
    public List<Category_detail> getCateDetail()
    {
        List<Category_detail> list = categoryDetailRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/byCategory")
    public List<Category_detail> getByCategory(@RequestParam("cate_id")Integer cate_id)
    {
        List<Category_detail> list = categoryDetailRepository.getByCateId(cate_id);
        return list;
    }

    @RequestMapping(path = "/status")
    public List<Category_detail> getByCateDetail(@RequestParam("status")Integer status)
    {
        List<Category_detail> list = categoryDetailRepository.findAllByStatus(status);
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<?> saveCateDetail(@Valid @RequestBody Category_detail category_detail)
    {
        try{
            category_detail.setCreated(new Date());
            category_detail.setUpdated(new Date());
            categoryDetailRepository.save(category_detail);
            return new ResponseEntity<Category_detail>(category_detail, HttpStatus.OK);

        }catch (NoSuchElementException e)
        {

        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Add new unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }


}
