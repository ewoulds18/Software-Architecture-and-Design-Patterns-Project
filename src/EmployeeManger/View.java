import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View extends Pane {
	
	public static final Color FILL_COLOR = Color.LIGHTBLUE;
	
	public View(){
		GridPane root = new GridPane();
		
		//Align content to center and set 10 pixel padding around elements
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		//title text
		Text headerText = new Text("Employee Manager");
		headerText.setFont(new Font("Times New Roman",40));
		
		//Text fields to input data
		TextField empName = new TextField();
		TextField empSalary = new TextField();
		TextField empNameToFind = new TextField();
		
		Text feedbackText = new Text();
		
		//labels for above the text fields
		Label empLabel = new Label("Employee Name");
		Label salLabel = new Label("Salary");
		Label empNameToFindLabel = new Label("Employee name to get subordinates");
		
		
		Button submit = new Button("Add Employee");
		submit.setOnAction(event -> {
			//get text from text fields and add to our composite here
			feedbackText.setText("Submitted: " + empName.getText());
			empName.clear();
			empSalary.clear();
		});
		
		Button find = new Button("Find Subordinates");
		find.setOnAction(event -> {
			//get text from text fields and get subordinates
			feedbackText.setText("Getting subordinates for: " + empNameToFind.getText());
			empNameToFind.clear();
		});
		
		//adding to root and layout elements
		root.add(headerText, 0, 0, 2, 1);
		root.add(empLabel, 0, 1);
		root.add(salLabel, 1, 1);
		root.add(empName, 0, 2);
		root.add(empSalary, 1, 2);
		root.add(submit, 2, 2);
		root.add(empNameToFindLabel, 0, 4);
		root.add(empNameToFind, 0, 5);
		root.add(find, 1, 5);
		root.add(feedbackText, 0,8 ,2, 1);
		
		this.getChildren().addAll(root);
	}
}
