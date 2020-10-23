import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.Slider
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent

public class HortonsController {
	
		@FXML // ResourceBundle that was given to the FXMLLoader
		private ResourceBundle resources;
	
		@FXML // URL location of the FXML file that was given to the FXMLLoader
		private URL location;
	
		@FXML // fx:id="typeSelector"
		private ComboBox<?> typeSelector; // Value injected by FXMLLoader
	
		@FXML // fx:id="numOfLinks"
		private TextField numOfLinks; // Value injected by FXMLLoader
	
		@FXML // fx:id="lenLin2"
		private TextField lenLin2; // Value injected by FXMLLoader
	
		@FXML // fx:id="lenLin3"
		private TextField lenLin3; // Value injected by FXMLLoader
	
		@FXML // fx:id="lenLin4"
		private TextField lenLin4; // Value injected by FXMLLoader
	
		@FXML // fx:id="lenLin1"
		private TextField lenLin1; // Value injected by FXMLLoader
	
		@FXML // fx:id="angleLin1"
		private TextField angleLin1; // Value injected by FXMLLoader
	
		@FXML // fx:id="distToCoupler"
		private TextField distToCoupler; // Value injected by FXMLLoader
	
		@FXML // fx:id="angleToCoupler"
		private TextField angleToCoupler; // Value injected by FXMLLoader
	
		@FXML // fx:id="startAngle"
		private TextField startAngle; // Value injected by FXMLLoader
	
		@FXML // fx:id="endAngle"
		private TextField endAngle; // Value injected by FXMLLoader
	
		@FXML // fx:id="deltaAngle"
		private TextField deltaAngle; // Value injected by FXMLLoader
	
		@FXML // fx:id="velocityOfCrank"
		private TextField velocityOfCrank; // Value injected by FXMLLoader
	
		@FXML // fx:id="positionSlider"
		private Slider positionSlider; // Value injected by FXMLLoader
	
		@FXML
		void liveMove(MouseEvent event) {
			println "Live move "+positionSlider.getValue()
		}
	
		@FXML
		void setType(ActionEvent event) {
			println "Set Type of Linkage"
		}
	
		@FXML
		void update(ActionEvent event) {
			println "Update Hortons"
		}
	
		@FXML // This method is called by the FXMLLoader when initialization is complete
		void initialize() {
			assert typeSelector != null : "fx:id=\"typeSelector\" was not injected: check your FXML file 'main.fxml'.";
			assert numOfLinks != null : "fx:id=\"numOfLinks\" was not injected: check your FXML file 'main.fxml'.";
			assert lenLin2 != null : "fx:id=\"lenLin2\" was not injected: check your FXML file 'main.fxml'.";
			assert lenLin3 != null : "fx:id=\"lenLin3\" was not injected: check your FXML file 'main.fxml'.";
			assert lenLin4 != null : "fx:id=\"lenLin4\" was not injected: check your FXML file 'main.fxml'.";
			assert lenLin1 != null : "fx:id=\"lenLin1\" was not injected: check your FXML file 'main.fxml'.";
			assert angleLin1 != null : "fx:id=\"angleLin1\" was not injected: check your FXML file 'main.fxml'.";
			assert distToCoupler != null : "fx:id=\"distToCoupler\" was not injected: check your FXML file 'main.fxml'.";
			assert angleToCoupler != null : "fx:id=\"angleToCoupler\" was not injected: check your FXML file 'main.fxml'.";
			assert startAngle != null : "fx:id=\"startAngle\" was not injected: check your FXML file 'main.fxml'.";
			assert endAngle != null : "fx:id=\"endAngle\" was not injected: check your FXML file 'main.fxml'.";
			assert deltaAngle != null : "fx:id=\"deltaAngle\" was not injected: check your FXML file 'main.fxml'.";
			assert velocityOfCrank != null : "fx:id=\"velocityOfCrank\" was not injected: check your FXML file 'main.fxml'.";
			assert positionSlider != null : "fx:id=\"positionSlider\" was not injected: check your FXML file 'main.fxml'.";
			println "Creating the controller for Hortons!"
			
		}
	}
	
return new HortonsController()