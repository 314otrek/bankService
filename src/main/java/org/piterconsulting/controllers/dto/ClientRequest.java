package org.piterconsulting.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ClientRequest {
    private String name;
    private String mail;


}
