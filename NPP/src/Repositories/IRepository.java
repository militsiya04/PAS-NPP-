package Repositories;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T> {
    List<T> getAll();
    T get(int id);
    List<T> find(Predicate<T> predicate);
    void create(T item);
    void update(T item);
    void delete(int id);
}