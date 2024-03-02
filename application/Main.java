package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//Alp Biricik 150122046
//Erencan Acıoğlu 150122056
//Kadir Akarca 150121052

/*This class is for launch the game 
 * that we called EKABA this class has the distance calculation,
 * score calculation, methods.*/
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		
	   int levelMeter = 1 ;
			  ArrayList<Integer> levels = new ArrayList();
		      levels.add(levelMeter);
		
		
		    BorderPane pane = new BorderPane();
			Scene scene = new Scene(pane,500,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("EKABA");
			Image kopke = new Image(getClass().getResourceAsStream("ponçik.jpg"));
			primaryStage.getIcons().add(kopke);
			
			GridPane top = new GridPane();
			GridPane center = new GridPane();
			GridPane bottom = new GridPane();
									
			GridPane center2 = new GridPane(); 
			GridPane center3 = new GridPane(); 
			GridPane center4 = new GridPane(); 
			GridPane center5 = new GridPane(); 
			
			Button btDrive = new Button("        DRIVE");
			Font font = Font.font("Arial", FontWeight.BOLD, 24);
			
			VBox vBox = new VBox();
	       	Label label = new Label();
	       	Label label2 = new Label();
			 
			Label score = new Label(); 
			Label nextLevel = new Label();
		

           ArrayList<City> cityList = new ArrayList();
          
           ArrayList<Integer> locations = new ArrayList();
           ArrayList<Integer> tempLocations = new ArrayList();
           
           ArrayList<Integer> scoreBoard = new ArrayList();
           int z = 0;
           scoreBoard.add(z);
           ArrayList<City> cityIDSort = new ArrayList();
           ArrayList<Fixed> fixedList = new ArrayList();
           ArrayList<Passenger> passengerList = new ArrayList();
           ArrayList<Vehicle> vehicleList = new ArrayList();
           
          
           
       	for(int i = 0; i < 10 ;i++) {
			 for(int k = 0 ; k < 10 ; k++) {
					Button bt = new Button();
					bt.setPrefHeight(50);
					bt.setPrefWidth(80);
					bt.setStyle("-fx-background-color: transparent;");
					center.add(bt, k, i);	
				}
			}
       	for(int i = 0; i < 10 ;i++) {
			 for(int k = 0 ; k < 10 ; k++) {
					Button bt = new Button();
					bt.setPrefHeight(50);
					bt.setPrefWidth(80);
					bt.setStyle("-fx-background-color: transparent;");
					center2.add(bt, k, i);	
				}
			}
       	for(int i = 0; i < 10 ;i++) {
			 for(int k = 0 ; k < 10 ; k++) {
					Button bt = new Button();
					bt.setPrefHeight(50);
					bt.setPrefWidth(80);
					bt.setStyle("-fx-background-color: transparent;");
					center3.add(bt, k, i);	
				}
			}
       	for(int i = 0; i < 10 ;i++) {
			 for(int k = 0 ; k < 10 ; k++) {
					Button bt = new Button();
					bt.setPrefHeight(50);
					bt.setPrefWidth(80);
					bt.setStyle("-fx-background-color: transparent;");
					center4.add(bt, k, i);	
				}
			}
       	for(int i = 0; i < 10 ;i++) {
			 for(int k = 0 ; k < 10 ; k++) {
					Button bt = new Button();
					bt.setPrefHeight(50);
					bt.setPrefWidth(80);
					bt.setStyle("-fx-background-color: transparent;");
					center5.add(bt, k, i);	
				}
			}
           
	    File file = new File("src/Levels/level1.txt");
	    Scanner input = new Scanner(file);
	    
	    File file2 = new File("src/Levels/level2.txt");
		Scanner input2 = new Scanner(file2);
		 
		
		File file3 = new File("src/Levels/level3.txt");
		Scanner input3 = new Scanner(file3);
		
		
		File file4 = new File("src/Levels/level4.txt");
		Scanner input4 = new Scanner(file4);
		
		File file5 = new File("src/Levels/level5.txt");
		Scanner input5 = new Scanner(file5);
		
	    
	    
	    
	   centerMethod(input,center,btDrive,label,label2,levels,cityList,locations,tempLocations,
	  		scoreBoard,fixedList,passengerList,vehicleList,cityIDSort);
	    
	    
	   
    		    label.setPrefHeight(40);
    		    label.setPrefWidth(320);
    		    
    		    
    		    vBox.getChildren().add(label);
    		    vBox.getChildren().add(label2);
    		    bottom.add(vBox, 0, 0);
    		    
    		    btDrive.setFont(font);
    		    btDrive.setTextFill(Color.GRAY);
    		    btDrive.setPrefHeight(120);
    		    btDrive.setPrefWidth(180);
    		    btDrive.setStyle("-fx-background-color: transparent;");
    		    
    		    
    		    btDrive.setOnAction(event -> {
    		    	System.out.println("You just drove");
                    int c = scoreBoard.get(0);
                   c +=  calculateScore(10,locations.get(0),locations.get(1),locations.get(2),locations.get(3));
                     scoreBoard.set(0, c);
                    score.setText("Score: " + scoreBoard.get(0));    
    			});
    			
    			for (int i = 0; i < 10; i++) {
    				 if(i == 0) {
    					
    					 nextLevel.setText("   Level#" +levels.get(0));
    					 nextLevel.setPrefHeight(20);
    					 nextLevel.setPrefWidth(120);
    					 
    			            top.add(nextLevel, i , 0);
    				 }
    				 
    				 else if(i == 4) {
    					 
    			            score.setText("Score: 0");
    			            score.setPrefHeight(20);
    			            score.setPrefWidth(150);
    			            //bt.setStyle("-fx-background-color: transparent;");
    			            top.add(score, i , 0);
    			           
    					 }
    				 else if(i == 9) {
    		            Button bt = new Button("Next level >>");
    		            bt.setPrefHeight(20);
    		            bt.setPrefWidth(150);
    		            bt.setTextFill(Color.GRAY);
    		           bt.setStyle("-fx-background-color: transparent;");
    		           
    		            bt.setOnAction(event -> {
    	                    System.out.println("Next Level button clicked!");
    	                    int temp = levels.get(0);
    	                    temp++;
    	                    levels.set(0, temp);
    	                     nextLevel.setText("   Level#"+levels.get(0)); 
    	                    
    	                    if(levels.get(0)== 6)
    		            		primaryStage.close();
    	                    
    	                    
    	                    cityList.clear();
    	                    if(levels.get(0)== 2) {
    	                    centerMethod(input2,center2,btDrive,label,label2,levels,cityList,locations,tempLocations,
    	            	    	scoreBoard,fixedList,passengerList,vehicleList,cityIDSort);
    	                        pane.setCenter(center2);
    	                        }
    	                    else if(levels.get(0)== 3){
    	                    	centerMethod(input3,center3,btDrive,label,label2,levels,cityList,locations,tempLocations,
    	    	            	    	scoreBoard,fixedList,passengerList,vehicleList,cityIDSort);
    	                        pane.setCenter(center3);

    	                    }
                            else if(levels.get(0)== 4){
                            	centerMethod(input4,center4,btDrive,label,label2,levels,cityList,locations,tempLocations,
            	            	    	scoreBoard,fixedList,passengerList,vehicleList,cityIDSort);
    	                        pane.setCenter(center4);

    	                    }
                            else if(levels.get(0)== 5){
                            	centerMethod(input5,center5,btDrive,label,label2,levels,cityList,locations,tempLocations,
            	            	    	scoreBoard,fixedList,passengerList,vehicleList,cityIDSort);
    	                        pane.setCenter(center5);

                            }
    	                  cityIDSort.clear();
    	                  
    		            });
    		            top.add(bt, i , 0);
    				 }
    				 else {
    				 Button bt = new Button();
    		            bt.setPrefHeight(20);
    		            bt.setPrefWidth(80);
    		            bt.setStyle("-fx-background-color: transparent;");
    		            top.add(bt, i , 0);  
    				 }
    			}


        	
			
			bottom.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
			top.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
			
					
	        bottom.add(btDrive, 5, 0);
	        
	      	
			center.setGridLinesVisible(false);
			center2.setGridLinesVisible(false);
			center3.setGridLinesVisible(false);
			center4.setGridLinesVisible(false);
			center5.setGridLinesVisible(false);
			
			top.setGridLinesVisible(false);
			bottom.setGridLinesVisible(false);
			        
			        pane.setTop(top);
					pane.setCenter(center);
					pane.setBottom(bottom);
			
			primaryStage.setScene(scene);
			primaryStage.show();    			
		  }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public static int calculateScore(int numberOfPassengers,int x1, int y1, int x2 , int y2) {
		double distance = calculateDistance(x1,y1,x2,y2);
		double cost = distance;
			double income = (numberOfPassengers) * (distance * 0.2);
			double score = income - cost;
		    return (int)score;
	}
	
	
	public static double calculateDistance(int x1, int y1, int x2 , int y2) {
		double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2- y1),2));
		return distance;
	}
	
 	public void centerMethod(Scanner input,GridPane center,Button btDrive,Label label1 ,Label label2 ,ArrayList<Integer> levels,
			ArrayList<City> cityList,ArrayList<Integer> locations,ArrayList<Integer> tempLocations,ArrayList<Integer> scoreBoard,
			ArrayList<Fixed> fixedList,ArrayList<Passenger> passengerList,ArrayList<Vehicle> vehicleList,ArrayList<City> cityIDSort) {
		int loc = 0;
       	int colV = 0;
	    int rowV= 0;
	    int n = 0;
	    int m = 1;
	   
        		while(input.hasNextLine()) {
        	
           String sentence = input.nextLine();
           String[] splitted = sentence.split(",");
            if(splitted[0].equals("Vehicle")) {
       	    int currentCityID =  Integer.parseInt(splitted[1]);
       	    int passengerCapacity =  Integer.parseInt(splitted[2]);
       	    
       	 for(int i = 0 ; i <cityList.size();i++) {
      	   for(City y : cityList) {
      		   if(y.getCityID()== i+1) {
      			   cityIDSort.add(cityList.get(i));
      		   }
      	   }
         }
       	    if(levels.get(0) == 2) {
       	    	loc = 43;
       	    }
       	    else if (levels.get(0) == 4 ) {
       	    	loc = 62;
       	    }
       	    else {	
       	     loc = cityIDSort.get(currentCityID-1).getCityLocation();
       	     }
       	      
       	    Button bt = new Button();
       	    Label carLabel = new Label();
       	    
       	    if(passengerCapacity < 6) {
       	    	Image image = new Image(getClass().getResourceAsStream("Car2.png"));
       	    	ImageView imageView = new ImageView(image);
       	    	imageView.setFitHeight(20);
                   imageView.setFitWidth(20);
                   carLabel.setGraphic(imageView);
       	    }
       	    else if(6 <= passengerCapacity && passengerCapacity < 14) {
       	    	Image image = new Image(getClass().getResourceAsStream("Minibüs.jpg"));
       	    	ImageView imageView = new ImageView(image);
       	    	imageView.setFitHeight(20);
                   imageView.setFitWidth(20);
                   carLabel.setGraphic(imageView);
       	    }
       	    else {
       	    	Image image = new Image(getClass().getResourceAsStream("LüksArtvin.jpg"));
       	    	ImageView imageView = new ImageView(image);
       	    	imageView.setFitHeight(20);
                   imageView.setFitWidth(20);
                   carLabel.setGraphic(imageView);
       	    }
       	    
   	    	Vehicle vehicle = new Vehicle(currentCityID,passengerCapacity);
       	    vehicleList.add(vehicle);
       	   
       	    bt.setPrefHeight(50);
				bt.setPrefWidth(80);
				bt.setStyle("-fx-background-color: transparent;");
			if(loc% 10 == 0) {
       	    	 colV = 9;
           	     rowV = (loc/10)-1 ;
           	    
       	    }
       	    else{
       	     colV = (loc%10)-1;
       	     rowV = (loc/10) ;
       	  
       	    }
       	    locations.add(colV);
       	    locations.add(rowV);
       		
            center.add(carLabel, colV, rowV);
       	   
            }
       
        		else if(splitted[0].equals("City")) {
        	   
        	   String cityName = splitted[1];
        	   int cityLocation = Integer.parseInt(splitted[2]);
        	   int cityID = Integer.parseInt(splitted[3]);
			
        	    Image image = new Image(getClass().getResourceAsStream(cityName+".jpg"));
      	    	ImageView imageView = new ImageView(image);
      	    	imageView.setFitHeight(40);
                imageView.setFitWidth(40);
       	    	
                Button bt = new Button();
        	    bt.setPrefHeight(50);
				bt.setPrefWidth(80);
				bt.setStyle("-fx-background-color: transparent;");
        	    int colC = 0;
        	    int rowC = 0;
        	    bt.setGraphic(imageView);
        	    if(cityLocation% 10 == 0) {
        	    	colC = 9;
            	    rowC = (cityLocation/10)-1 ;}
        	    else {
        	    	colC = (cityLocation%10-1);
           	        rowC = (cityLocation/10) ;
        	    }
        	    
        	    tempLocations.add(n, colC);
        	    tempLocations.add(m, rowC);
                n+=2;
                m+=2;
        	    center.add(bt, colC, rowC);
        	    
        	    bt.setOnAction(e -> {
					
        	    	for(int x = 0; x<tempLocations.size();x+=2) {
        		        if(cityLocation == (tempLocations.get(x+1)*10)+(tempLocations.get(x)+1)) {
        	                  if(locations.size() < 3 ) {			 
        				       locations.add(tempLocations.get(x));
        				       locations.add(tempLocations.get(x+1));
        				       }
        	                  else {
        	                	  locations.set(2,tempLocations.get(x));
        	                	  locations.set(3,tempLocations.get(x+1));
        	                  }
        		        }
        	    	}
        	    	label1.setText((cityName + " CityID: " + cityID +", Distance " + 
        	(int)calculateDistance(locations.get(0),locations.get(1),locations.get(2),locations.get(3))+", Vehicle Capacity: " + vehicleList.get(levels.get(0)-1).getPassengerCapacity()));
					String a = "" ;
				    for(int i = 0 ; i <passengerList.size(); i++) {
				    	if((passengerList.get(i).getDestinationCityID() == cityID) 
				    		|| (passengerList.get(i).getStartingCityID() == cityID)) {
				    		for(int k = 0 ; k < cityList.size();k++) {
				    			for(int j = 0 ; j < cityList.size(); j ++) {
				    			if(passengerList.get(i).getStartingCityID()==cityList.get(k).getCityID()&& 
				    					passengerList.get(i).getDestinationCityID() == cityList.get(j).getCityID() ) {
				    		a += (cityList.get(k).getCityName()+ " > " + cityList.get(j).getCityName() +
				    				" (" + passengerList.get(i).getNumberOfPassenger() + " Passengers) \n");
				    	}
				    }
				}
		    }
			    	label2.setText(a);
	 }
				    
				   btDrive.setTextFill(Color.BLACK); 
        	    });  
        	    City city = new City(cityName,cityLocation,cityID);
       	    	cityList.add(city);
        		}
	
           
           else if(splitted[0].equals("Fixed")){
        	   int fixedLocation = Integer.parseInt(splitted[1]);
        	   Fixed fixed = new Fixed(fixedLocation);
        	   Image image = new Image(getClass().getResourceAsStream("Fixed.jpg"));
   	    	ImageView imageView = new ImageView(image);
   	    	imageView.setFitHeight(40);
   	    	imageView.setFitWidth(40);
   	    	Button bt = new Button();
   	    	bt.setPrefHeight(50);
			bt.setPrefWidth(80);
			bt.setStyle("-fx-background-color: transparent;");
	        bt.setGraphic(imageView);
			int rowF,colF;
    	    if(fixedLocation% 10 == 0) {
    	    	colF = 9;
    	    	rowF = (fixedLocation/10) - 1 ;
    	    }
    	    else{
    	    	colF = (fixedLocation%10) - 1;
    	    	rowF = (fixedLocation/10);
            }
    	    center.add(bt, colF, rowF);
   	    	
        	   fixedList.add(fixed);
           }
           else if(splitted[0].equals("Passenger")) {
        	    int numberOfPassenger = Integer.parseInt(splitted[1]);
        	    int startingCityID = Integer.parseInt(splitted[2]);
        	    int destinationCityID = Integer.parseInt(splitted[3]);
        	    Passenger passenger = new Passenger(numberOfPassenger,startingCityID ,destinationCityID);
        	    passengerList.add(passenger);
           }          
        		}
	}
}