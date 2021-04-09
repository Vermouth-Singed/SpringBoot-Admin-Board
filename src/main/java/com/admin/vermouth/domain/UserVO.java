package com.admin.vermouth.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_list")
public class UserVO extends CommonVO{
    @Id
    private String userId;

    private String userPassword;
    private String userName;
    private LocalDateTime updateDate;
    private LocalDateTime registerDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<BoardVO> boardList;
}