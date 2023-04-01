/*
package net.ejazcurd.springbootcurd.controller;


import net.ejazcurd.springbootcurd.model.Employee;
import net.ejazcurd.springbootcurd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee)
    {
        Employee empsaved = employeeService.saveEmp(employee);
        return new ResponseEntity<Employee>(empsaved , new HttpHeaders(), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> update(@Valid @RequestBody Employee employee, @PathVariable long id)
    {
        employeeService.updateUser(employee,id);
        Employee empl =new Employee();
        empl.setId(employee.getId());
        empl.setFirstname(employee.getFirstname());
        empl.setLastname(employee.getLastname());
        empl.setEmail(employee.getEmail());
        Employee empsaved = employeeService.saveEmp(empl);
        return new ResponseEntity<Employee>(empsaved , new HttpHeaders(), HttpStatus.CREATED);
    }
//update method in differnt way
    @PutMapping("/put/update/{id}")
    Employee updateEmployee(@RequestBody Employee newemployee, @PathVariable long id)
    {
        return employeeService.updateEmployee(newemployee,id);
    }

    @GetMapping("/getall")
    public List<Employee> getallemployee()
    {
        return employeeService.findAllUsers();
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id)
    {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
    */
/*public Employee create(@Valid @RequestBody Employee employee)
    {
        Employee empsaved = employeeService.saveEmp(employee);
        return empsaved;
    }*//*


    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id )
    {
        employeeService.deleteUserById(id);
        return "user " +id + " is deleted successfully";
    }
    */
/*public ResponseEntity<Object> deleteById(@PathVariable long id)
    {

        *//*
*/
/*try{
            employeeService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }*//*
*/
/*
        employeeService.deleteUserById(id);
           return new ResponseEntity<Object> (HttpStatus.OK);

       *//*
*/
/* Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.NOT_FOUND);*//*
*/
/*
       // return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

}
*/
