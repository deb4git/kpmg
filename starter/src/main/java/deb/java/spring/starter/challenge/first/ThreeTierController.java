package deb.java.spring.starter.challenge.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//This Code will be invoked from React UI Application layer
@RequestMapping("hello")
@RestController
public class ThreeTierController {
    @Autowired
    ThreeTierService threeTierService;


    @PostMapping("/employee")
    public long save(final @RequestBody Employee employee) {
        threeTierService.save(employee);
        return employee.getId();
    }

    @GetMapping("/employee")
    public List<Employee> getAll() {
        return threeTierService.getAll();
    }
}
