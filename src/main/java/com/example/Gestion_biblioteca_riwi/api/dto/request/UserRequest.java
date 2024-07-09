package com.example.Gestion_biblioteca_riwi.api.dto.request;

import com.example.Gestion_biblioteca_riwi.utils.enums.TypeRol;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "el nombre de usuario es requerido")
    @Size(min = 1, max = 50)
    private String userName;

    @NotNull(message = "la contraseña es requerida")
    private String password;

    @NotNull(message = "el correo del estudiante es requerido")
    @Email(message = "el correo del estudiante debe ser valido")
    private String email;

    @NotBlank(message = "el nombre completo del usuario es requerido")
    @Size(min = 1, max = 100)
    private String fullName;

    @NotNull(message = "se debe asignar un rol al usuario")
    private TypeRol role;

}
