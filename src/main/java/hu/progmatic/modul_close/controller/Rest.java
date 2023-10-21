package hu.progmatic.modul_close.controller;

import hu.progmatic.modul_close.model.Order;
import hu.progmatic.modul_close.model.Person;
import hu.progmatic.modul_close.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {

    private EntityService entityService;
    @GetMapping("/persons")
    public List<Person> getAllPerson(){
        return entityService.getAllPerson();
    }
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return entityService.getAllOrder();
    }
}
