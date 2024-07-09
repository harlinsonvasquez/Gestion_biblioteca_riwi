package com.example.Gestion_biblioteca_riwi.api.dto.response;

import com.example.Gestion_biblioteca_riwi.utils.enums.TypeRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResp {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private TypeRol role;
    private List<ReservationBasicResp> reservations;
    private List<LoanBasicResp> loans;


}
