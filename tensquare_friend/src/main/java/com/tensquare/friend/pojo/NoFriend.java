package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author chenyilei
 * @date 2018/12/03-16:38
 * hello everyone
 */
@Entity
@Table(name="tb_nofriend")
@IdClass(NoFriend.class)
@Data
public class NoFriend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;

}
