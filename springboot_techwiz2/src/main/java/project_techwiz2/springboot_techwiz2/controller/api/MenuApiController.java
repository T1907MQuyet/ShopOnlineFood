package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.model.core.Menu;
import project_techwiz2.springboot_techwiz2.repository.core.MenuRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "api/menu")
public class MenuApiController {
    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(path = "")
    private List<Menu> getMenus()
    {
        List<Menu> list = menuRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/status")
    private List<Menu> getMenuByStatus(@RequestParam("status")Integer status)
    {
        List<Menu> list = menuRepository.findAllByStatus(status);
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<?> saveMenu(@Valid @RequestBody Menu menu)
    {
        try{
            menu.setCreated(new Date());
            menu.setUpdated(new Date());
            menuRepository.save(menu);
            return new ResponseEntity<Menu>(menu,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {

        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Add new unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
