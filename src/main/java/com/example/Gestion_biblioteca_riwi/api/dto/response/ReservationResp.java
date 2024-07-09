package com.example.Gestion_biblioteca_riwi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResp extends ReservationBasicResp{
    private UserBasicResp userEntity;
}
