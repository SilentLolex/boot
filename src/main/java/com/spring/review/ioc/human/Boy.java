package com.spring.review.ioc.human;

import com.spring.review.annotation.MyComponent;
import com.spring.review.ioc.obj.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: SilentLolex
 * @Date: 2022/1/13 8:54
 */
@Component
@MyComponent
public class Boy {

    @Autowired
    private Car car;

    public void drive() {
        car.run();
    }
}
