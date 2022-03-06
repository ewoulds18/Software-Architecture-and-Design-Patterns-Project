package src.EmployeeManger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View extends Pane {
	
	private int empId = 5;
	
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
		empName.setMaxWidth(200);
		TextField empSalary = new TextField();
		empSalary.setMaxWidth(100);
		TextField empAddress = new TextField();
		empAddress.setMaxWidth(100);
		
		TextArea feedbackText = new TextArea();
		feedbackText.setEditable(false);
		feedbackText.setMaxWidth(2000);
		
		//labels for above the text fields
		Label empLabel = new Label("Employee Name");
		Label salLabel = new Label("Salary");
		Label addressLabel = new Label("Address");
		Label empListLabel = new Label("Add to list: ");
		Label empNameToFindLabel = new Label("Employee name to get subordinates/passengers");
		
		//manager and carpool lists
		Manager CEO = new Manager("Eric", 1, 60000, "Fredericton");
		Manager Manager = new Manager("Fadi", 2, 55000, "Fredericton");
		Manager Manager2 = new Manager("Anoma", 3, 55000, "Fredericton");
		Employee emp = new Employee("Jordan", 4, 50000, "Fredericton");
		CEO.add(Manager);
		CEO.add(Manager2);
		Manager.add(emp);
		
		//Drop down menu to select list to add employee too
		ObservableList<String> options =
				FXCollections.observableArrayList(
						"CEO",
						"Manager",
						"Manager2",
						"Carpool1",
						"Carpool2"
				);
		final ComboBox listOptions = new ComboBox(options);
		final ComboBox findListOptions = new ComboBox(options);
		
		Button submit = new Button("Add Employee");
		submit.setOnAction(event -> {
			//get text from text fields and add to our composite here
			//Add employee to list here
			switch (listOptions.getValue().toString()){
				case("CEO"):
					CEO.add(new Employee(empName.getText(), empId, Double.parseDouble(empSalary.getText()), empAddress.getText()));
					feedbackText.setText("Added Employee: "+ empName.getText());
					break;
				case("Manager"):
					Manager.add(new Employee(empName.getText(), empId, Double.parseDouble(empSalary.getText()), empAddress.getText()));
					feedbackText.setText("Added Employee: "+ empName.getText());
					break;
				case("Manager2"):
					Manager2.add(new Employee(empName.getText(), empId, Double.parseDouble(empSalary.getText()), empAddress.getText()));
					feedbackText.setText("Added Employee: "+ empName.getText());
					break;
				case("Carpool1"):
					feedbackText.setText("Not yet Implemented");
					break;
				case("Carpool2"):
					feedbackText.setText("Nopt yet Implemented");
					break;
			}
			empName.clear();
			empSalary.clear();
			empAddress.clear();
		});
		
		Button find = new Button("Find Subordinates");
		find.setOnAction(event -> {
			//get text from text fields and get subordinates
			switch (findListOptions.getValue().toString()){
				case("CEO"):
					feedbackText.setText(CEO.toString());
					break;
				case("Manager"):
					feedbackText.setText(Manager.toString());
					break;
				case("Manager2"):
					feedbackText.setText(Manager2.toString());
					break;
				case("Carpool1"):
					feedbackText.setText("Not yet Implemented");
					break;
				case("Carpool2"):
					feedbackText.setText("Nopt yet Implemented");
					break;
			}
			empId++;
		});
		
		//adding to root and layout elements
		root.add(headerText, 1, 0, 4, 1);
		root.add(empLabel, 0, 1);
		root.add(salLabel, 1, 1);
		root.add(addressLabel, 2, 1);
		root.add(empListLabel, 3, 1);
		root.add(empName, 0, 2);
		root.add(empSalary, 1, 2);
		root.add(empAddress, 2, 2);
		root.add(listOptions, 3, 2);
		root.add(submit, 4, 2);
		root.add(empNameToFindLabel, 0, 4);
		root.add(findListOptions, 0, 5, 2, 1);
		root.add(find, 1, 5);
		root.add(feedbackText, 0,8, 10, 1);
		
		this.getChildren().addAll(root);
	}
}
