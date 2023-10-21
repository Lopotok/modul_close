package hu.progmatic.modul_close.service;

import hu.progmatic.modul_close.model.Order;
import hu.progmatic.modul_close.model.Person;
import hu.progmatic.modul_close.repo.OrderRepo;
import hu.progmatic.modul_close.repo.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {

    private PersonRepo personRepo;
    private OrderRepo orderRepo;

    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    public Person getPersonById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }

    public List<Order> getAllOrdersByPerson(Person person) {
        return orderRepo.getOrderByOwner(person);
    }

    public void savePerson(Person person) {
        personRepo.save(person);
    }

    public void saveOrder(Order order) {
        orderRepo.save(order);
    }

           public Person getMostOrdersPerson(Person person) {
               return orderRepo.findPersonWithMostOrders();
           }

}