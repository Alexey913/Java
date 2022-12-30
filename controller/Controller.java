package controller;

public interface Controller<E, I> {
    E create(E entity);

    E save(E entity);

    E findById(I id);
}