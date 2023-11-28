package com.jiyunieo.demo.Repository;

import com.jiyunieo.demo.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<LoginUser, Integer> {
    //JPA : 데이터베이스와 연결해줌
    boolean existsByUserId(String userId); // 값을 넣을 때 엔티티 변수이름과 같게 넣어야 함
}
