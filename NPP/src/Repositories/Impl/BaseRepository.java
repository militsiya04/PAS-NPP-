package Repositories.Impl;

import Repositories.IRepository;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseRepository<T> implements IRepository<T> {

    private final HashMap<Integer, T> items;

    public BaseRepository() {
        items = new HashMap<>();
    }

    @Override
    public List<T> getAll() {
        return items.values().stream().collect(Collectors.toList());
    }

    @Override
    public T get(int id) {
        return items.get(id);
    }

    @Override
    public List<T> find(Predicate<T> predicate) {
        return items.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void create(T item) {
        items.put(getItemId(item), item);
    }

    @Override
    public void update(T item) {
        if (items.containsKey(getItemId(item))) {
            items.put(getItemId(item), item);
        }
    }

    @Override
    public void delete(int id) {
        items.remove(id);
    }

    protected abstract int getItemId(T item);
}