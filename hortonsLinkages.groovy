import com.neuronrobotics.bowlerstudio.scripting.ScriptingEngine

import javafx.fxml.FXMLLoader
import javafx.scene.control.Tab
import javafx.scene.layout.Pane

// This is a simple linkages generator
println "Launching Hortons Linkages"

File xml = ScriptingEngine.fileFromGit("https://github.com/WPIRoboticsEngineering/HortonsLinkages.git", "main.fxml")
Pane newLoadedPane =  FXMLLoader.load(xml.toURI().toURL());

// Create a tab
Tab myTab = new Tab();
//set the title of the new tab
myTab.setText("Hortons Linkages");
//add content to the tab
myTab.setContent(newLoadedPane);

return myTab