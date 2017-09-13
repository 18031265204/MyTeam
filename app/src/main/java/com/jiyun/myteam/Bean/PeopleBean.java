package com.jiyun.myteam.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by lenovo on 2017/9/12.
 */
@Entity
public class PeopleBean {
    @Id(autoincrement = true)
    private Long uid;
    @Property(nameInDb = "numbel")
    private String phonenumbel;
    @Property(nameInDb = "password")
    private String password;
    @Generated(hash = 1633693872)
    public PeopleBean(Long uid, String phonenumbel, String password) {
        this.uid = uid;
        this.phonenumbel = phonenumbel;
        this.password = password;
    }
    @Generated(hash = 2089139229)
    public PeopleBean() {
    }
    public Long getUid() {
        return this.uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getPhonenumbel() {
        return this.phonenumbel;
    }
    public void setPhonenumbel(String phonenumbel) {
        this.phonenumbel = phonenumbel;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
