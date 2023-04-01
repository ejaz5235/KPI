/*
package net.ejazcurd.springbootcurd.service;


import net.ejazcurd.springbootcurd.exception.RecordNotFoundException;
import net.ejazcurd.springbootcurd.exception.UserNotFoundException;
import net.ejazcurd.springbootcurd.model.Employee;
import net.ejazcurd.springbootcurd.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepository empRepository;
    @Override
    public Employee findById(long id) {
        Employee byId = empRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));

        return byId;
    }
   */
/* public Employee findById(long id) {
        return empRepository.findById(id).get();
    }*//*

   @Override
   public String deleteUserById(long id) {

       if(!empRepository.existsById(id)){
           throw new UserNotFoundException(id);
       }
       empRepository.deleteById(id);
       return "user with "+id+ " has been deleted successfully";
       */
/*Boolean result = empRepository.existsById(id);
       empRepository.deleteById(id);
       System.out.println(result);
       return "{\"success\"  : " + (result ? "true" : "false") + "}";*//*


   }
    @Override
    public Employee findByName(String name) {
        return null;
    }

    @Override
    public Employee saveEmp(Employee emp) {
        Employee save = empRepository.save(emp);
        return save;
       // return empRepository.save(emp);
    }

    @Override
    public Employee updateUser(Employee emp, long id) {
       Employee employee = empRepository.findById(id)
               .orElseThrow(()->new RecordNotFoundException("user not present to update "+id));
        return empRepository.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee newemp, long id) {
       return empRepository.findById(id)
               .map(employee -> {
                   employee.setFirstname(newemp.getFirstname());
                   employee.setLastname(newemp.getLastname());
                   employee.setEmail(newemp.getEmail());
                   return empRepository.save(employee);
               }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<Employee> findAllUsers() {

        List<Employee> emplist = empRepository.findAll();
        return emplist;
    }


    @Override
    public boolean isUserExist(Employee emp) {
        return false;
    }
}
*/
