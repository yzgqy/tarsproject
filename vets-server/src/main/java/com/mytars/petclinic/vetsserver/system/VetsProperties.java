package com.mytars.petclinic.vetsserver.system;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 14:51
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "vets")
public class VetsProperties {

    private Cache cache;

    @Data
    public static class Cache {

        private int ttl;

        private int heapSize;
    }
}
