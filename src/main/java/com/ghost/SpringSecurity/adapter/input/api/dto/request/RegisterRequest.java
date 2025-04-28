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
public class RegisterRequest {

    @NotBlank(message = "El nombre es requerido.")
    private String name;

    @Email(message = "Correo no valido.")
    private String email;

    @NotBlank(message = "La contraseña es requerida.")
    @Length(max = 8, message = "La contraseña debe ser de minimo 8 carateres.")
    private String password;
}
