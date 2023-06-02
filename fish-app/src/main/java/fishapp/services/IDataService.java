package fishapp.services;

import java.util.List;
import java.util.Optional;

public interface IDataService<T> {
    List<T> findAll();
    T save(T object);
    Optional<T> findByID(int id);
    T findByName(String name);
}
