package com.admin.vermouth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDTO {
    private long id;

    private String userId;
    private String status;

    private int pageNo;
    private int rowSize;
}