package boardServer.reservation.model;

import java.time.LocalDate;

public class Reservation {
	private String id;
	private String car;
	private int carCode;
	private LocalDate rentStartDate;
	private LocalDate rentEndDate;
	private String payState;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public int getCarCode() {
		return carCode;
	}
	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}
	public LocalDate getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(LocalDate rentStartDate) {
		this.rentStartDate = rentStartDate;
	}
	public LocalDate getRentEndDate() {
		return rentEndDate;
	}
	public void setRentEndDate(LocalDate rentEndDate) {
		this.rentEndDate = rentEndDate;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
}
