package com.ghost.SpringSecurity.domain.port.crud;

import java.util.List;

public interface IGetAll<T> {
    List<T> getAll();
}
