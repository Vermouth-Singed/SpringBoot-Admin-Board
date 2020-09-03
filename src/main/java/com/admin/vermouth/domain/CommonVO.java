package com.admin.vermouth.domain;

import lombok.Data;

@Data
public class CommonVO {
    private int rank;
    private String user_password_re;
    private boolean delete_checked;
    private boolean update_checked;
    private String status;
    private String jwt_token;
    private String jwt_key;
}