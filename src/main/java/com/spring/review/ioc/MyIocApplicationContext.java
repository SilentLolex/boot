package com.spring.review.ioc;

import com.spring.review.annotation.MyComponent;
import com.spring.review.annotation.MyComponentScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MyIocApplicationContext extends DefaultResourceLoader {

    private Map<String, Class<?>> classMap = new ConcurrentHashMap<>(16);

    public MyIocApplicationContext(Class<?> configClass) {
        String basePackage = getBasePackage(configClass);
        if (!StringUtils.hasText(basePackage)) {
            basePackage = configClass.getPackage().getName();
        }
        scanPackage(basePackage);
        log.info(classMap.toString());
    }

    private String getBasePackage(Class<?> configClass) {
        Assert.notNull(configClass, "主配置类不可为空");
        MyComponentScan myComponentScan = configClass.getAnnotation(MyComponentScan.class);
        return myComponentScan.value();
    }

    private void scanPackage(String packagePath) {
        File dir = new File(this.getClass().getResource("/").getPath() + packagePath.replace(".", "/"));
        if (!dir.exists()) {
            return;
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scanPackage(new StringBuilder(packagePath).append(".").append(file.getName()).toString());
            } else {
                Class<?> targetClass = null;
                String targetClassPath = new StringBuilder(packagePath).append(".").append(file.getName().substring(0, file.getName().indexOf(".class"))).toString();
                try {
                    targetClass = ClassLoader.getSystemClassLoader().loadClass(targetClassPath);
                } catch (ClassNotFoundException e) {
                    log.error("loadClass error", e);
                    continue;
                }
                MyComponent annotation = targetClass.getAnnotation(MyComponent.class);
                if (annotation != null) {
                    classMap.put(targetClassPath, targetClass);
                }
            }
        }
    }


}
