package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("Kat Laydee")
                .address("Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .name("Fern Pollin")
                .address("Flora City")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .name("Carey Wales")
                .address("Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Dawg")
                .address("Bark Street")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Mario Mama")
                .address("Mushroom Kingdom")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Brody Kill")
                .address("Highway 50")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex,Math.min(firstIndex + pageSize, organizerList.size()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }
}