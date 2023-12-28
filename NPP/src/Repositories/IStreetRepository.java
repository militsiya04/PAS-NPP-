package Repositories;

import Entities.Street;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IStreetRepository implements IRepository<Street> {

    private HashMap<Integer, Street> streets;

    public IStreetRepository() {
        streets = new HashMap<>();
    }

    @Override
    public List<Street> getAll() {
        return new ArrayList<>(streets.values());
    }

    @Override
    public Street get(int id) {
        return streets.get(id);
    }

    @Override
    public List<Street> find(java.util.function.Predicate<Street> predicate) {
        List<Street> result = new ArrayList<>();
        for (Street street : streets.values()) {
            if (predicate.test(street)) {
                result.add(street);
            }
        }
        return result;
    }

    @Override
    public void create(Street item) {
        streets.put(item.getId(), item);
    }

    @Override
    public void update(Street item) {
        streets.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        streets.remove(id);
    }
}
