package com.ghost.SpringSecurity.domain.port.crud;

public interface IGetById<T, ID> {
    T getById(ID id);
}
