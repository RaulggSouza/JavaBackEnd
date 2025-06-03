import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, K>{
    void save(T t);
    Optional<T> findByCode(K k);
    List<Optional<T>> findAll();
    void update(T t);
    void delete (K k);
}
