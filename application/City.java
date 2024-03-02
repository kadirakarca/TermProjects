package application;

//Alp Biricik 150122046
//Erencan Acıoğlu 150122056
//Kadir Akarca 150121052

//This is a city class it has the cities locations, ID's , names
public class City {
  private String cityName;
  private int cityLocation;
  private int cityID;
  
  City(String cityName,int cityLocation,int cityID){
	  this.cityID= cityID;
	  this.cityLocation= cityLocation;
	  this.cityName = cityName;
  }

public String getCityName() {
	return cityName;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

public int getCityLocation() {
	return cityLocation;
}

public void setCityLocation(int cityLocation) {
	this.cityLocation = cityLocation;
}

public int getCityID() {
	return cityID;
}

public void setCityID(int cityID) {
	this.cityID = cityID;
}

  
 
}
