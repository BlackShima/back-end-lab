package se331.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import se331.lab.entity.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
}
