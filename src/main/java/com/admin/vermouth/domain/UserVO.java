package com.admin.vermouth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Accessors(chain = true)
@Entity(name="user_list")
public class UserVO extends CommonVO{
    @Id
    private String userId;
    private String userPassword;
    private String userName;
    private LocalDate updateDate;
    private LocalDate registerDate;
}