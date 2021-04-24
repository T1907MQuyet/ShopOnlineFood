package project_techwiz2.springboot_techwiz2.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.model.core.Menu_detail;
import project_techwiz2.springboot_techwiz2.repository.core.MenuDetailRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "api/menuDetail")
public class MenuDetailApiController {
    @Autowired
    private MenuDetailRepository menuDetailRepository;

    @RequestMapping(path = "")
    public List<Menu_detail> getMenuDetail()
    {
        List<Menu_detail> list = menuDetailRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/status")
    public List<Menu_detail> getByStatus(@RequestParam("status")Integer status)
    {
        List<Menu_detail> list = menuDetailRepository.findAllByStatus(status);
        return list;
    }

    @RequestMapping(path = "/byMenu")
    public List<Menu_detail> getByMenuId(@RequestParam("menu_id")Integer menu_id)
    {
        List<Menu_detail> list = menuDetailRepository.getByMenuId(menu_id);
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<?> saveMenuDetail(@Valid @RequestBody Menu_detail menu_detail)
    {
        try {
            menu_detail.setCreated(new Date());
            menu_detail.setUpdated(new Date());
            menuDetailRepository.save(menu_detail);
            return new ResponseEntity<Menu_detail>(menu_detail,HttpStatus.OK);

        }catch (NoSuchElementException e)
        {

        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Add new unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
