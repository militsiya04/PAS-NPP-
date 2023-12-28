package Repositories;

import Entities.Plumbing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IPlumbingRepository implements IRepository<Plumbing> {

    private HashMap<Integer, Plumbing> plumbingItems;

    public IPlumbingRepository() {
        plumbingItems = new HashMap<>();
    }

    @Override
    public List<Plumbing> getAll() {
        return new ArrayList<>(plumbingItems.values());
    }

    @Override
    public Plumbing get(int id) {
        return plumbingItems.get(id);
    }

    @Override
    public List<Plumbing> find(java.util.function.Predicate<Plumbing> predicate) {
        List<Plumbing> result = new ArrayList<>();
        for (Plumbing plumbing : plumbingItems.values()) {
            if (predicate.test(plumbing)) {
                result.add(plumbing);
            }
        }
        return result;
    }

    @Override
    public void create(Plumbing item) {
        plumbingItems.put(item.getId(), item);
    }

    @Override
    public void update(Plumbing item) {
        plumbingItems.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        plumbingItems.remove(id);
    }
}
