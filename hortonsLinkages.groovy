import com.neuronrobotics.bowlerstudio.scripting.ScriptingEngine

import javafx.fxml.FXMLLoader
import javafx.scene.control.Tab
import javafx.scene.layout.Pane

// This is a simple linkages generator
println "Launching Hortons Linkages"
/**
 * Sample Skeleton for 'main.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

def controller = ScriptingEngine.gitScriptRun(
            "https://github.com/WPIRoboticsEngineering/HortonsLinkages.git", // git location of the library
            "controller.groovy" , // file to load
            null
            )

File xml = ScriptingEngine.fileFromGit("https://github.com/WPIRoboticsEngineering/HortonsLinkages.git", "main.fxml")
FXMLLoader loader = new FXMLLoader(xml.toURI().toURL())
loader.setController(controller)
Pane newLoadedPane =  loader.load();
Thread.sleep(1000);

// Create a tab
Tab myTab = new Tab();
//set the title of the new tab
myTab.setText("Hortons Linkages");
//add content to the tab
myTab.setContent(newLoadedPane);

return myTab