package org.srclib.java;

public class JDK8062359 { 
    public static void main(String[] args) { 
        new Undefined() { 
            void test() { 
                new Object() {}; 
            } 
        }; 
    } 
} 
