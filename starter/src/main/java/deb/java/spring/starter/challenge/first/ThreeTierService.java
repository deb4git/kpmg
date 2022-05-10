package deb.java.spring.starter.challenge.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThreeTierService {
    @Autowired
    ThreeTierRepository threeTierRepository;

    public void save(final Employee employee) {
        threeTierRepository.save(employee);
    }

    public List<Employee> getAll() {
        final List<Employee> employeeList = new ArrayList<>();
        threeTierRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }
}
