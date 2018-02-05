package cn.com.hystrix.bidinfo.market;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class BidedNotice implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String owner;

    private String ownerPhone;
}
