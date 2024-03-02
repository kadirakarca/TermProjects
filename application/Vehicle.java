package application;

//Alp Biricik 150122046
//Erencan Acıoğlu 150122056
//Kadir Akarca 150121052
//This is a vehicle class it has vehicles current city ID and passenger capacity
public class Vehicle {
 private int currentCityID;
 private int passengerCapacity;
 
 Vehicle(int currentCityID,int passengerCapacity){
	 this.currentCityID = currentCityID;
	 this.passengerCapacity = passengerCapacity;
 }

public int getCurrentCityID() {
	return currentCityID;
}

public void setCurrentCityID(int currentCityID) {
	this.currentCityID = currentCityID;
}

public int getPassengerCapacity() {
	return passengerCapacity;
}

public void setPassengerCapacity(int passengerCapacity) {
	this.passengerCapacity = passengerCapacity;
}
}
