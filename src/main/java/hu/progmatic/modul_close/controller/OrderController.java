package hu.progmatic.modul_close.controller;

import hu.progmatic.modul_close.model.Order;
import hu.progmatic.modul_close.model.Person;
import hu.progmatic.modul_close.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private EntityService entityService;

    @GetMapping("/new/{person-id}")
    public String createOrder(Model model, @PathVariable("person-id") Integer personId) {
        model.addAttribute("personId", personId);
        model.addAttribute("order",new Order());
        return "order_form";
    }

    @PostMapping("/add/{person-id}")
    public String createOrder (@ModelAttribute("order") Order order, @PathVariable ("person-id") Integer personId) {
        order.setOwner(entityService.getPersonById(personId));
        entityService.saveOrder(order);
        return "redirect:/home";
    }
}
