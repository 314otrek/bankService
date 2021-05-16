package org.piterconsulting.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.piterconsulting.repository.entity.Account;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private Long id;
    private String name;
    private String mail;
    private List<Long> accounts;
}
