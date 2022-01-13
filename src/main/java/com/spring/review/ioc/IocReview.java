package com.spring.review.ioc;

import com.spring.review.annotation.MyComponentScan;
import com.spring.review.ioc.human.Boy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: SilentLolex
 * @Date: 2022/1/13 8:39
 */

// 告诉Spring从哪个包下扫描Bean，不写就是当前包路径
//@ComponentScan(basePackages = "com.spring.ioc")
@MyComponentScan("com.spring.review.ioc")
public class IocReview {
    public static void main(String[] args) {
        // 将Main(配置信息)传入到ApplicationContext(IoC容器)中
        ApplicationContext context = new AnnotationConfigApplicationContext(IocReview.class);
        // 从(IoC容器)中获取到我们的boy
        Boy boy = (Boy) context.getBean("boy");  // 开车
        boy.drive();
    }
}
