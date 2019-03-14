package com.example.demo.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //Annotation based configuration
public class Payment {
	
	private long tripId;	
	private PartnerDriver driver;	
	private double amount;
	
	//superclass constructor
	public Payment() {
		super();
		System.out.println("======= Payment constructor called =====");
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public Payment(long tripId, PartnerDriver driver, double amount) {
		super();
		this.tripId = tripId;
		this.driver = driver;
		this.amount = amount;
	}
	
	//getters setters
	
	public long getTripId() {
		return tripId;
	}
	@Value("10100")
	public void setTripId(long tripId) {
		System.out.println("SET TRIPID CALLED");
		this.tripId = tripId;
	}

	public PartnerDriver getdriver() {
		return driver;
	}
	@Autowired
	public void setdriver(PartnerDriver driver) {
		System.out.println("SET DRIVER CALLED");
		this.driver = driver;
	}

	public double getAmount() {
		return amount;
	}
	@Value("432.00")
	public void setAmount(double amount) {
		System.out.println("SET AMOUNT CALLED");
		this.amount = amount;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Payment [tripId=" + tripId + ", driver=" + driver + ", amount=" + amount + "]";
	}
	
}
