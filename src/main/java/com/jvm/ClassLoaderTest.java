package com.jvm;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader grandPa = parent.getParent();
        System.out.println(grandPa);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        for (URL urL : urLs) {
            System.out.println(urL);
        }


    }
}
