package com.admin.vermouth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Accessors(chain = true)
public class UserVO implements Serializable {
    private String user_id;
    private String user_password;
    private String user_name;
    private String update_date;
    private String register_date;
    private int rank;
    private String user_password_re;
    private boolean delete_checked;
    private boolean update_checked;
    private String status;
    private String jwt_token;
    private String jwt_key;
}