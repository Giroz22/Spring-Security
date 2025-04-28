package com.ghost.SpringSecurity.domain.port.input;

import com.ghost.SpringSecurity.domain.model.UserModel;
import com.ghost.SpringSecurity.domain.port.crud.IDelete;
import com.ghost.SpringSecurity.domain.port.crud.IGetAll;
import com.ghost.SpringSecurity.domain.port.crud.IGetById;
import com.ghost.SpringSecurity.domain.port.crud.IUpdate;

public interface UserServicePort extends 
    IGetAll<UserModel>,
    IGetById<UserModel, String>,
    IUpdate<UserModel, String>,
    IDelete<String>    
{
    UserModel getByEmail(String email);
}
