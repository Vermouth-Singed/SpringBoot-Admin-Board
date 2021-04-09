package com.admin.vermouth.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="board_list")
public class BoardVO extends CommonVO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardNo;

    private String userId;
}