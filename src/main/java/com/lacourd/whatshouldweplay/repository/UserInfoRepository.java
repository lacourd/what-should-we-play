package com.lacourd.whatshouldweplay.repository;

import com.lacourd.whatshouldweplay.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    @Override
    Optional<UserInfo> findById(Integer integer);


    Optional<UserInfo> findByName(String userName);
}
