package com.fanxing.model.entity.user;

import com.fanxing.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    private String username;
    private String password;
}
