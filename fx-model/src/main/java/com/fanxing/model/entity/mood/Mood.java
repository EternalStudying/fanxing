package com.fanxing.model.entity.mood;

import com.fanxing.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class Mood extends BaseEntity {
    private Long uid;
    private String des;
    private String image;
}
