package com.company.annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Child1 extends MainClass{

    @BeforeSuite
    public void chBeforeSuite(){
        System.out.println("Child1 - Before Suite");
    }

    @BeforeClass
    public void chBeforeClass(){
        System.out.println("Child1 - Before Class");
    }

    @BeforeMethod
    public void chBeforeMethod(){
        System.out.println("Child1 - Before Method");
    }

    @Test
    public void test11(){
        System.out.println("Child1 - test11");
    }

    @Test
    public void test12(){
        System.out.println("Child1 - test12");
    }
}
