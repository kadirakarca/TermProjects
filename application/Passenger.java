package application;

//Alp Biricik 150122046
//Erencan Acıoğlu 150122056
//Kadir Akarca 150121052

//This is a passenger class it has the passengers number,current city,destination city
public class Passenger {
private int numberOfPassenger;
private int startingCityID;
private int destinationCityID;

Passenger(int numberOfPassenger,int startingCityID,int destinationCityID){
	this.destinationCityID=destinationCityID;
	this.numberOfPassenger = numberOfPassenger;
	this.startingCityID = startingCityID;
}

public int getNumberOfPassenger() {
	return numberOfPassenger;
}

public void setNumberOfPassenger(int numberOfPassenger) {
	this.numberOfPassenger = numberOfPassenger;
}

public int getStartingCityID() {
	return startingCityID;
}

public void setStartingCityID(int startingCityID) {
	this.startingCityID = startingCityID;
}

public int getDestinationCityID() {
	return destinationCityID;
}

public void setDestinationCityID(int destinationCityID) {
	this.destinationCityID = destinationCityID;
}
}
