package com.example.demo.domains;

import com.example.demo.ifaces.DiscountService;
import com.example.demo.utils.ShowExecutionTime;

public class Billing implements DiscountService {

	@Override
	public double cashDiscount() {		
		return 0.10;
	}

	@Override
	@ShowExecutionTime
	public String[] getCoupons() {
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String[] {"Shoppers Stop", "Pizza Hut", "Tata Sky"};
	}

}
