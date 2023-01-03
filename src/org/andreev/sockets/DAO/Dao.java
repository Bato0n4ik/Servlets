package org.andreev.sockets.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T,R> {

    public Optional<T> findById(R id);

    public List<T> findAll();

    public void insert(T object);

    public boolean delete(R id);

    public void update(T object);
}
