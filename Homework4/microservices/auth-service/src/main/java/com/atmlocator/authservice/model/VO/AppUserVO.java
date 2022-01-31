package com.atmlocator.authservice.model.VO;
/*
    Created by Labina on 29-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserVO {

    Long id;
    String username;
    String password;
    String email;
    String accountRole;

}
