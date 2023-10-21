package hu.progmatic.modul_close.repo;

import hu.progmatic.modul_close.model.Order;
import hu.progmatic.modul_close.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    List<Order> getOrderByOwner (Person person);

    @Query("SELECT MAX(o.amount) FROM Order o WHERE o.owner.id=: personId")
    Person findPersonWithMostOrders();
}
