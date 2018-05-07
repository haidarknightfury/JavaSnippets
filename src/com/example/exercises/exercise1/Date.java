package com.example.exercises.exercise1;

public class Date {

	private int day;
	private int month;
	private int year;

	int daysofyear[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}

	// R 28
	public boolean isLeap(int year) {
		return year % 4 > 0;
	}

	public int calculateDays( Date date2) {
		int total = 0;
		// from current date to end of month
		total += daysofyear[this.getMonth() - 1] - this.getDay();
		// current month to end of year month
		for (int i = this.getMonth(); i < daysofyear.length; i++) {
			total += daysofyear[i];
		}

		for (int x = this.getYear() + 1; x <= date2.getYear() - 1; x++) {
			for (int j = 0; j < 12; j++) {
				total += daysofyear[j];
			}
		}

		// last year
		for (int j = 0; j < date2.getMonth(); j++) {
			total += daysofyear[j];
		}

		return total;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}