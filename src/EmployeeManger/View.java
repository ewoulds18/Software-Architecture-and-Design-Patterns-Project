package src.EmployeeManger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View extends Pane {
	
	private int empId = 5;
	
	public View(){
		GridPane root = new GridPane();
		
		// Align content to center and set 10 pixel padding around elements
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		//manager and carpool lists
		Manager CEO = new Manager("Eric", 1, 40, "Fredericton");
		CEO.setIsCeo(true);
		Manager Manager = new Manager("Fadi", 2, 35, "Fredericton");
		Manager Manager2 = new Manager("Anoma", 3, 35, "Fredericton");
		Employee emp = new Employee("Jordan", 4, 30, "Fredericton");
		CarPool cp1 = new CarPool("Eric", 1, 40, "Fredericton");
		CarPool cp2 = new CarPool("Fadi", 2, 35, "Fredericton");
		CarPool cp3 = new CarPool("Jordan", 4, 30, "Fredericton");
		
		CEO.add(Manager);
		CEO.add(Manager2);
		Manager.add(emp);
		
		//Text area to put feedback when actions are completed
		TextArea feedbackText = new TextArea();
		feedbackText.setEditable(false);
		feedbackText.setMaxWidth(2000);
		
		/************************************************************
			All Lists used for dropdown menus
		 */
		ObservableList<Employee> employees =
				FXCollections.observableArrayList(
						CEO,
						Manager,
						Manager2,
						emp
				);
		
		ObservableList<String> options =
				FXCollections.observableArrayList(
						"CEO",
						"Manager",
						"Manager2"
				);
		
		ObservableList<String> allLists =
				FXCollections.observableArrayList(
						"CEO",
						"Manager",
						"Manager2",
						"CarPool1",
						"CarPool2",
						"CarPool3"
				);
		
		ObservableList<String> carPools =
				FXCollections.observableArrayList(
						"CarPool1",
						"CarPool2",
						"CarPool3"
				);
		
		ObservableList<String> payOptions =
				FXCollections.observableArrayList(
						"Get Salary",
						"Get Weekly Salary",
						"Get Monthly Salary",
						"Get Bonus"
				);
		
		ObservableList<Employee> empToRemove =
				FXCollections.observableArrayList(
						emp
				);
		
		//title text
		Text headerText = new Text("Employee Manager");
		headerText.setFont(new Font("Times New Roman",40));
		
		/************************************************************
			Code for removing employees
		 */
		
		Label removeListLabel = new Label("Employee to remove");
		
		ComboBox removeList = new ComboBox(empToRemove);
		removeList.setMaxWidth(100);
		
		Button removeButton = new Button("Remove Employee");
		removeButton.setOnAction(e->{
			Employee remove = (Employee) removeList.getValue();
			if(remove != null){
				CEO.Remove(remove);
				Manager.Remove(remove);
				Manager2.Remove(remove);
				employees.remove(remove);
				empToRemove.remove(remove);
				feedbackText.setText("Removed: " + remove);
			}else{
				feedbackText.setText("Please select employee to remove");
			}
		});
		
		/************************************************************
			Fields to for updating an employee record
		 */
		
		//labels for above the text fields
		Label empNameLabel = new Label("Employee Name");
		
		final ComboBox empList = new ComboBox<>(employees);
		empList.setMaxWidth(100);
		TextField updateField = new TextField();
		
		//Buttons to update Values
		Button updatePayButton = new Button("Update Pay");
		Button updateAddressButton = new Button("Update Address");
		
		updatePayButton.setOnAction(event -> {
			Employee temp = (Employee) empList.getValue();
			if(temp != null){
				try{
					Double newPay = Double.parseDouble(updateField.getText());
					temp.setSalary(newPay, feedbackText);
				}catch (Exception e){
					feedbackText.setText("Please enter number to update salary");
				}
			}else{
				feedbackText.setText("Please select employee to update information");
			}
		});
		updateAddressButton.setOnAction(event -> {
			Employee temp = (Employee) empList.getValue();
			if(temp != null && updateField.getText() != null){
				temp.setAddress(updateField.getText(), feedbackText);
			}else{
				feedbackText.setText("Please enter new address in text field and select employee");
			}
			
		});
		
		/************************************************************
			Code for Adding Employees to an existing list as a subordinate
		 */
		
		//Text fields to input data
		TextField empName = new TextField();
		empName.setMaxWidth(150);
		TextField empSalary = new TextField();
		empSalary.setMaxWidth(100);
		TextField empAddress = new TextField();
		empAddress.setMaxWidth(100);
		
		//labels for above the text fields
		Label empLabel = new Label("Employee Name");
		Label salLabel = new Label("Salary (hourly)");
		Label addressLabel = new Label("Address");
		Label empListLabel = new Label("Add to list: ");
		
		
		final ComboBox listOptions = new ComboBox(options);
		
		Button submitButton = new Button("Add Employee");
		submitButton.setOnAction(event -> {
			//get text from text fields and add to our composite here
			//Add employee to list here
			if(!empName.getText().isEmpty() && !empSalary.getText().isEmpty() && !empAddress.getText().isEmpty() ){
				Employee toAdd = new Employee(empName.getText(), empId, Double.parseDouble(empSalary.getText()), empAddress.getText());
				if(listOptions.getValue() != null){
					switch (listOptions.getValue().toString()){
						case("CEO"):
							CEO.add(toAdd);
							feedbackText.setText("Added Employee: "+ empName.getText());
							break;
						case("Manager"):
							Manager.add(toAdd);
							feedbackText.setText("Added Employee: "+ empName.getText());
							break;
						case("Manager2"):
							Manager2.add(toAdd);
							feedbackText.setText("Added Employee: "+ empName.getText());
							break;
					}
					employees.add(toAdd);
					empToRemove.add(toAdd);
					empName.clear();
					empSalary.clear();
					empAddress.clear();
				}else{
					feedbackText.setText("Please select list to add employee to");
				}
			}else{
				feedbackText.setText("Please fill out all fields to add employee");
			}
		});
		
		/************************************************************
			Code for Listing all Employees under CEO or Manager
		 */
		
		Label empNameToFindLabel = new Label("Employee name to get subordinates/passengers");
		
		final ComboBox findListOptions = new ComboBox(allLists);
		
		Button findButton = new Button("Find Subordinates");
		findButton.setOnAction(event -> {
			//get text from text fields and get subordinates
			if(findListOptions.getValue() != null){
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
					case("CarPool1"):
						feedbackText.setText(cp1.toString());
						break;
					case("CarPool2"):
						feedbackText.setText(cp2.toString());
						break;
					case("CarPool3"):
						feedbackText.setText(cp3.toString());
						break;
				}
			}else{
				feedbackText.setText("Please select list");
			}
		});
		
		/************************************************************
			Code to Calc employee pay
		 */
		
		final ComboBox empList2 = new ComboBox(employees);
		empList2.setMaxWidth(100);
		
		final ComboBox payOps = new ComboBox(payOptions);
		
		Button salaryButton = new Button("Calculate Salary");
		salaryButton.setOnAction(e->{
			Employee temp = (Employee )empList2.getValue();
			IEmployee employeeCheck = new Payroll(temp);

			if(temp != null){
				if(payOps.getValue() != null){
					switch (payOps.getValue().toString()) {
						case ("Get Salary"):
							employeeCheck.CalculateSalary();
							feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateSalary() + " an hour");
							break;
						case ("Get Weekly Salary"):
							employeeCheck.CalculateWeeklySalary();
							feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateWeeklySalary() + " a week");
							break;
						case ("Get Monthly Salary"):
							temp.CalculateMonthlySalary();
							feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateMonthlySalary() + " a Month");
							break;
						case ("Get Bonus"):
							employeeCheck.CalculateBonusSalary(temp.getIsCeo());
							feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateBonusSalary(temp.getIsCeo()) + " for bonus pay");
							break;
					}
				}else{
					feedbackText.setText("Please select an Salary option");
				}
			}else{
				feedbackText.setText("Please select an employee");
			}
		});
		
		Label empNameLabel2 = new Label("Employee  name");
		Label payTypeLabel = new Label("Pay Type");
		
		/************************************************************
			Code to Add existing Employee to a carpool
		 */
		
		
		Label nameLabel = new Label("Employee Name");
		Label carPoolLabel = new Label("Car Pools");
		
		ComboBox carpool = new ComboBox(carPools);
		ComboBox carPoolNames = new ComboBox(employees);
		carPoolNames.setMaxWidth(100);
		
		Button addToCarPoolButton = new Button("Add To Car Pool");
		
		addToCarPoolButton.setOnAction(e->{
			if(carpool.getValue() != null && carPoolNames.getValue() != null){
				Employee tempEmp = (Employee) carPoolNames.getValue();
				switch (carpool.getValue().toString()){
					case("CarPool1"):
						cp1.add(tempEmp);
						feedbackText.setText("Add "+ tempEmp.getName() + " to carpool1");
						break;
					case("CarPool2"):
						cp2.add(tempEmp);
						feedbackText.setText("Add "+ tempEmp.getName() + " to carpool2");
						break;
					case("CarPool3"):
						cp3.add(tempEmp);
						feedbackText.setText("Add "+ tempEmp.getName() + " to carpool3");
						break;
				}
			}else{
				feedbackText.setText("Please Select an Employee and Carpool from list");
			}
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
		root.add(submitButton, 4, 2);
		root.add(empNameToFindLabel, 0, 4);
		root.add(findListOptions, 0, 5);
		root.add(findButton, 1, 5);
		root.add(empNameLabel, 0, 6);
		root.add(empList, 0, 7);
		root.add(updateField, 1, 7);
		root.add(updateAddressButton, 2, 7);
		root.add(updatePayButton, 3, 7);
		root.add(empNameLabel2, 0,8);
		root.add(payTypeLabel, 1, 8);
		root.add(empList2, 0, 9);
		root.add(payOps, 1, 9);
		root.add(salaryButton, 2, 9);
		root.add(carPoolLabel, 0, 10);
		root.add(nameLabel, 1, 10);
		root.add(carpool, 0, 11);
		root.add(carPoolNames, 1, 11);
		root.add(addToCarPoolButton, 2, 11);
		root.add(removeListLabel, 0, 12);
		root.add(removeList, 0, 13);
		root.add(removeButton, 1, 13);
		root.add(feedbackText, 0,14, 10, 1);
		
		this.getChildren().addAll(root);
	}
}
