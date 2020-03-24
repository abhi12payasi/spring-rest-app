package com.app.controller;

import com.app.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    private static List<Employee> employeeList = new ArrayList<>();

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Employee employee){
        employeeList.add(employee);
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(
                "Saved successfully !!" ,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/show")
    public ResponseEntity<?> getAll(){
        ResponseEntity<?> responseEntity = null;
        if(employeeList.size()>0){
            responseEntity = new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
        }
        else{
            responseEntity = new ResponseEntity<String>("No Data Found !! " ,HttpStatus.OK );
        }
        //System.out.println(responseEntity);
        return responseEntity;
    }
}
