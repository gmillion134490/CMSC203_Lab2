
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
	private Button spanishButton; // optional sixth button (just for fun)
	private Label feedbackLabel;
	private TextField textField;
	//  declare two HBoxes
	private HBox labelFieldBox, buttonBox;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		spanishButton = new Button("Spanish");
		feedbackLabel = new Label("Feedback:");
		textField = new TextField();
		//  instantiate the HBoxes
		labelFieldBox = new HBox();
		buttonBox = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		
		//  set the buttons to respond to clicks
		ButtonHandler handler = new ButtonHandler();
		helloButton.setOnAction(handler);
		howdyButton.setOnAction(handler);
		chineseButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		exitButton.setOnAction(handler);
		spanishButton.setOnAction(handler);
		
		//  set margins and set alignment of the components
		Insets inset = new Insets(10);
		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(spanishButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);
		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(textField, inset);
		labelFieldBox.setAlignment(Pos.CENTER);
		buttonBox.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		labelFieldBox.getChildren().addAll(feedbackLabel, textField);
		//  add the buttons to the other HBox
		buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, 
				spanishButton, clearButton, exitButton);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(labelFieldBox, buttonBox);
		this.setAlignment(Pos.CENTER);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object target = event.getTarget();
			if (target == helloButton) {
				textField.setText(dataManager.getHello());
			} else if (target == howdyButton) {
				textField.setText(dataManager.getHowdy());
			} else if (target == chineseButton) {
				textField.setText(dataManager.getChinese());
			} else if (target == spanishButton) {
				textField.setText(dataManager.getSpanish());
			} else if (target == clearButton) {
				textField.setText("");
			} else if (target == exitButton) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
