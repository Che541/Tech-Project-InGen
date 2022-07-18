package com.ingen;


import com.ingen.controllers.EmployeeController;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeedaoInterface;
import com.ingen.service.EmployeeService;
import com.ingen.service.EmployeeServiceInterface;

import io.javalin.Javalin;

public class Main {
    

    public static void main(String[] args) {


        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

        }).start();

        EmployeedaoInterface employeeDao = new EmployeeDao();
        EmployeeServiceInterface employeeService = new EmployeeService(employeeDao);
        EmployeeController employeeController = new EmployeeController(employeeService);

        app.get("/hello", employeeController.getHelloWorld);

        app.get("/employee", employeeController.getAllEmployees);
        
    }
    
}