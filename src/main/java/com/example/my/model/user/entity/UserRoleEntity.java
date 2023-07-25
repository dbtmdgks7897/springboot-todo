package com.example.my.model.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Integer idx;

    // N대1 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    // 엔티티 자체를 넣고, user_idx의 idx 컬럼과 연결하겠다.
    @JoinColumn(name = "user_idx", referencedColumnName = "idx", updatable = false, nullable = false)
    // 변수명이 UserEntity에서 mappedBy 속성에 넣을 값과 똑같아야 함
    private UserEntity userEntity;

    @Column(name = "role")
    private String role;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
