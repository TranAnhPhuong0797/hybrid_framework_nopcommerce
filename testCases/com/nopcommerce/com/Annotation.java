package com.nopcommerce.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotation {
  @Test
  public void testcase() {
	  System.out.println("Run testcase");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Run Before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Run After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Run Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Run After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Run Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Run After Suite");
  }

}
