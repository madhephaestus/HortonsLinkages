import com.neuronrobotics.bowlerstudio.creature.MobileBaseLoader
import com.neuronrobotics.sdk.addons.kinematics.MobileBase

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.Slider
import javafx.scene.control.TableColumn
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent

public class HortonsController {
	MobileBase system;

	@FXML
	private TableColumn<?, ?> l1AngleColumn;

	@FXML
	private TableColumn<?, ?> l2AngleColumn;

	@FXML
	private TableColumn<?, ?> l3AngleColumn;

	@FXML
	private TableColumn<?, ?> l4AngleColumn;

	@FXML
	private TableColumn<?, ?> transAngleColumn;

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
		double lower = Double.parseDouble(startAngle.getText())
		double upper = Double.parseDouble(endAngle.getText())
		double range = (upper-lower)*positionSlider.getValue()/100.0;
		println "Live move "+range
		
		setLinkAngle(range)
	}
	
	void setLinkAngle(double angle) {
		def crank =system.getAllDHChains().get(0).getAbstractLink(0)
		crank.setCurrentEngineeringUnits(angle)
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

		def cl = new ChangeListener<Boolean>(){
					@Override
					public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
					{
						if (!newPropertyValue)
						{
							update(null);
						}
					}
				}
		velocityOfCrank.focusedProperty().addListener(cl)
		numOfLinks.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		lenLin2.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		lenLin3.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		lenLin4.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		lenLin1.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		angleLin1.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		distToCoupler.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		angleToCoupler.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		startAngle.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		endAngle.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		deltaAngle.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		velocityOfCrank.focusedProperty().addListener(cl); // Value injected by FXMLLoader
		
		system = DeviceManager.getSpecificDevice( "FourBarGroup",{
			MobileBase m = MobileBaseLoader.fromGit("https://github.com/WPIRoboticsEngineering/HortonsLinkages.git", "fourbar.xml")
			return m
		})
		
		
		update(null)
	}
}

return new HortonsController()

