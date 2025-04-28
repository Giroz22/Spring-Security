package com.ghost.SpringSecurity.domain.port.input;

import com.ghost.SpringSecurity.domain.model.UserModel;

public interface AuthServicePort {
    String Login(UserModel user);
    String Register(UserModel user);
}
