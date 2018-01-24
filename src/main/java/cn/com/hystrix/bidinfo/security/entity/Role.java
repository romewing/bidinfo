package cn.com.hystrix.bidinfo.security.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Role")
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;


    // private Set<Authority> authorities;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    @Override
    public String getAuthority() {
        return StringUtils.upperCase(getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Role that = (Role) obj;
        return Objects.equals(this.id, that.id);
    }
}
