package com.atmlocator.bankservice.model.VO;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmIdsList {
    List<Long> ids;
}
