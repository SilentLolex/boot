package com.spring.review.ioc.obj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: SilentLolex
 * @Date: 2022/1/13 8:43
 */
@Slf4j
@Component
public class Mclaren implements Car {

    @Override
    public void run() {
        log.info("aha! GP2 engine.");
    }

}
