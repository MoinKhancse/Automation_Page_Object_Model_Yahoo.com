package Utilities;

import Drivers.BaseDriver;

public class CommonMethods extends BaseDriver{
	public static void timeOut() throws InterruptedException {
		Thread.sleep(2000);
	} 
	public static void timeOut(int time) throws InterruptedException {
		Thread.sleep(time);
	}

}
