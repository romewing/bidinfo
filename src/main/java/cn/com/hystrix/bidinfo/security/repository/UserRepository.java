package cn.com.hystrix.bidinfo.security.repository;

import cn.com.hystrix.bidinfo.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
