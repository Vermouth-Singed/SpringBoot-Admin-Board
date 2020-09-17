package com.admin.vermouth.viewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonViewModel {
    private long id;

    private String userId;
    private String status;

    private int pageNo;
    private int rowSize;
}