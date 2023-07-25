package com.example.my.model.user.repository;

import com.example.my.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(String id);

    // 삭제가 안된 유저 ID로 검색
    Optional<UserEntity> findByIdAndDeleteDateIsNull(String id);

    Optional<UserEntity> findByIdxAndDeleteDateIsNull(Long idx);
}
