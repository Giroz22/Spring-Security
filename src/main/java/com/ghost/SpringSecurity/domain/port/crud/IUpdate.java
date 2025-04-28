package com.ghost.SpringSecurity.domain.port.crud;

public interface IUpdate<T, ID> {
    T update(ID id, T entity);
}
