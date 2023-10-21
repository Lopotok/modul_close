package hu.progmatic.modul_close.controller;

import hu.progmatic.modul_close.model.Person;
import hu.progmatic.modul_close.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private EntityService entityService;

    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Integer id) {
        Person person = entityService.getPersonById(id);
        model.addAttribute("orders",entityService.getAllOrdersByPerson(person));
        model.addAttribute("person",person);
        return "person";
    }
    @GetMapping("/new")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person_form";
    }
    @PostMapping("/add")
    public String createPerson(@ModelAttribute("person") Person person) {
        entityService.savePerson(person);
        return "redirect:/home";
    }
    @GetMapping("/update/{id}")
    public String updatePerson(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("person", entityService.getPersonById(id));
        return "person_update";
    }
    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Integer id, @ModelAttribute("person") Person updated) {
        entityService.savePerson(updated);
        return "redirect:/person/" + id;
    }
/*    @GetMapping("/most-order")
    public String getMostOrder(Model model) {
        Person person = entityService.getMostOrdersPerson();
        model.addAttribute("person", person);
        model.addAttribute("order", entityService.getMostOrdersPerson());
        return "person";
 */
}
