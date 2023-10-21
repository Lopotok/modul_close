package hu.progmatic.modul_close.repo;

import hu.progmatic.modul_close.model.Order;
import hu.progmatic.modul_close.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface PersonRepo extends JpaRepository<Person,Integer> {



}
