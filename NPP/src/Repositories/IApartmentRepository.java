package Repositories;

import Entities.Apartment;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IApartmentRepository implements IRepository<Apartment> {

    private HashMap<Integer, Apartment> apartments;

    public IApartmentRepository() {
        apartments = new HashMap<>();
    }

    @Override
    public List<Apartment> getAll() {
        return apartments.values().stream().collect(Collectors.toList());
    }

    @Override
    public Apartment get(int id) {
        return apartments.get(id);
    }

    @Override
    public List<Apartment> find(Predicate<Apartment> predicate) {
        return apartments.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void create(Apartment item) {
        apartments.put(item.getId(), item);
    }

    @Override
    public void update(Apartment item) {
        if (apartments.containsKey(item.getId())) {
            apartments.get(item.getId()).setNumber(item.getNumber());
        }
    }

    @Override
    public void delete(int id) {
        apartments.remove(id);
    }
}