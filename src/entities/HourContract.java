package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private double valuePerHour;
	private int hour;
	
	public HourContract() {
		super();
	}

	public HourContract(Date date, double valuePerHour, int hour) {
		super();
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public double totalValue() {
		return this.valuePerHour * hour;
	}
}
