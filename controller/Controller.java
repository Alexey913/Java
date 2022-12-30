package controller;

public interface Controller<E, I> {
    E save(E entity);

    E findById(I id);
}