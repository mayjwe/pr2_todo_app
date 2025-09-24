package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public boolean clear() {
        this.items.clear();

        return items.isEmpty();
    }

    public String done(int index) {
        String task = items.get(index);

        task = task + " -- completed";
        items.set(index, task);

        return items.get(index);
    }

    public Set<String> search(String substring) {
        return items.stream()
                .filter(
                        x -> x.contains(substring)
                )
                .collect( Collectors.toSet() );
    }

    public int size() {
        return items.size();
    }
}