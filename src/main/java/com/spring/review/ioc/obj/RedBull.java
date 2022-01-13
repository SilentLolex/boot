package com.spring.review.ioc.obj;

import com.spring.review.annotation.MyComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: SilentLolex
 * @Date: 2022/1/13 8:45
 */
@Slf4j
// @Component
@MyComponent
public class RedBull  implements Car{

    @Override
    public void run() {
        log.info("sorry, we lost power.");
    }
}
