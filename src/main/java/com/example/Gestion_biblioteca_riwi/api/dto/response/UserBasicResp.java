package com.example.Gestion_biblioteca_riwi.api.dto.response;

import com.example.Gestion_biblioteca_riwi.utils.enums.TypeRol;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResp {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private TypeRol role;
}
