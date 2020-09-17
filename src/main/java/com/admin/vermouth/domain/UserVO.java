package com.admin.vermouth.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Accessors(chain = true)
@Entity(name="sample_user")
public class UserVO extends CommonVO{
    @Id
    private String userId;
    private String userPassword;
    private String userName;
    private LocalDateTime updateDate;
    private LocalDateTime registerDate;
}