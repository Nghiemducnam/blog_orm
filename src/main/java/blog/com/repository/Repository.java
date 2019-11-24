package blog.com.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(long id);

    void save(T model);

    void remove(long id);
}

