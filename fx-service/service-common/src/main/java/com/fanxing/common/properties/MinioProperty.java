package com.fanxing.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fx.minio")
@Data
public class MinioProperty {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
