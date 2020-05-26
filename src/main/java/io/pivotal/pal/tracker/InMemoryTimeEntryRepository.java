package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        long id = currentId++;

        timeEntry.setId(id);

        timeEntries.put(id, timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (find(id) == null) return null;
        else
        {
            timeEntry.setId(id);
            timeEntries.replace(id, timeEntry);

        }
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }
}
