package com.ghost.SpringSecurity.domain.port.output;

import com.ghost.SpringSecurity.domain.model.UserModel;
import com.ghost.SpringSecurity.domain.port.crud.ICreate;
import com.ghost.SpringSecurity.domain.port.crud.IDelete;
import com.ghost.SpringSecurity.domain.port.crud.IGetAll;
import com.ghost.SpringSecurity.domain.port.crud.IGetById;
import com.ghost.SpringSecurity.domain.port.crud.IUpdate;

public interface UserPersistencePort extends 
    ICreate<UserModel>, 
    IUpdate<UserModel, String>, 
    IGetAll<UserModel>, 
    IGetById<UserModel, String>, 
    IDelete<String>
{
    UserModel findUserByEmail(String Email);
}
