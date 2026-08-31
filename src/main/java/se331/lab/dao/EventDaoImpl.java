package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(1L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petsAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(2L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petsAllowed(true)
                .organizer("Fern Pollin")
                .build());
        eventList.add(Event.builder()
                .id(3L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petsAllowed(false)
                .organizer("Carey Wales")
                .build());
        eventList.add(Event.builder()
                .id(4L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petsAllowed(true)
                .organizer("Fern Pollin")
                .build());
        eventList.add(Event.builder()
                .id(5L)
                .category("Mum Ma Mia")
                .title("It's me")
                .description("Mario!")
                .location("Thailand")
                .date("July 06, 2577")
                .time("98:00")
                .petsAllowed(true)
                .organizer("Mario Mama")
                .build());
        eventList.add(Event.builder()
                .id(6L)
                .category("sustainability")
                .title("Higway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petsAllowed(false)
                .organizer("Brody Kill")
                .build());
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return eventList.subList(firstIndex,Math.min(firstIndex + pageSize, eventList.size()));
    }

    @Override
    public Event getEvent(Long id) {
        return eventList.stream().filter(event ->
                event.getId().equals(id)).findFirst().orElse(null);
    }
}
