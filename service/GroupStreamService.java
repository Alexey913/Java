package service;

import java.util.List;

public interface GroupStreamService<E, I> {
    void sortGroupStream(List<E> entity);

    E saveGroupStream(E entity);

    E findByIdGroupStream(I id);
}