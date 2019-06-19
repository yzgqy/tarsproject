package com.mytars.petclinic.vetsserver.system;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 14:50
 * @Description:
 */
@Configuration
@EnableCaching
@Profile("production")
class CacheConfig {
}
