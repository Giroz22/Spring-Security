package com.ghost.SpringSecurity.adapter.input.api.dto.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {

    @Email(message = "Correo no valido.")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacia.")
    @Length(min = 8, message = "La contraseña debe ser de minimo 8 caracteres.")
    private String password;
}
