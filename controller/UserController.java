package controller;

import data.User;

public interface UserController<E extends User, I> extends Controller<E, I> {
    public abstract E read(E entity);

    public abstract E findUserByFio(String fio);
}