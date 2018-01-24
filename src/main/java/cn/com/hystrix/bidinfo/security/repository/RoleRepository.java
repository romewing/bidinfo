package cn.com.hystrix.bidinfo.security.repository;

import cn.com.hystrix.bidinfo.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
