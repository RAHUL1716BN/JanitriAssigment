package Testcases;

import org.testng.annotations.AfterSuite;

import Base.base;



public class Basetest {


	@AfterSuite
	public void tearDown() {
    base.quitDriver();
}
}
