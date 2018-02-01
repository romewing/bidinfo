package cn.com.hystrix.bidinfo.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Authority implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String url;

    private String icon;

    private String description;

    private Integer type;

    private Integer sort;

    @ManyToOne
    private Authority parent;

}
