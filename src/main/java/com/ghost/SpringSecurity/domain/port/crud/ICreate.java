package com.ghost.SpringSecurity.domain.port.crud;

public interface ICreate<T> {
    T create(T entity);
}
