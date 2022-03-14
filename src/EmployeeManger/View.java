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
		
		//Drop down menu to select list to add employee too
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
		
		//title text
		Text headerText = new Text("Employee Manager");
		headerText.setFont(new Font("Times New Roman",40));
		
		/*
			Fields to for updating an employee record
		 */
		ObservableList<Employee> employees =
				FXCollections.observableArrayList(
						CEO,
						Manager,
						Manager2,
						emp
				);
		
		//labels for above the text fields
		Label empNameLabel = new Label("Employee Name");
		
		final ComboBox empList = new ComboBox<>(employees);
		empList.setMaxWidth(100);
		TextField updateField = new TextField();
		
		//Buttons to update Values
		Button updatePay = new Button("Update Pay");
		Button updateAddress = new Button("Update Address");
		
		updatePay.setOnAction(event -> {
			Employee temp = (Employee) empList.getValue();
			temp.setSalary(Double.parseDouble(updateField.getText()), feedbackText);
		});
		updateAddress.setOnAction(event -> {
			Employee temp = (Employee) empList.getValue();
			temp.setAddress(updateField.getText(), feedbackText);
		});

		
		/*
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
		
		Button submit = new Button("Add Employee");
		submit.setOnAction(event -> {
			Employee toAdd = new Employee(empName.getText(), empId, Double.parseDouble(empSalary.getText()), empAddress.getText());
			//get text from text fields and add to our composite here
			//Add employee to list here
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
			empName.clear();
			empSalary.clear();
			empAddress.clear();
		});
		
		/*
			Code for Listing all Employees under CEO or Manager
		 */
		
		Label empNameToFindLabel = new Label("Employee name to get subordinates/passengers");
		
		final ComboBox findListOptions = new ComboBox(allLists);
		
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
			empId++;
		});
		/*
			Code to Calc employee pay
		 */
		final ComboBox empList2 = new ComboBox(employees);
		empList2.setMaxWidth(100);
		
		ObservableList<String> payOptions =
				FXCollections.observableArrayList(
						"Get Salary",
						"Get Weekly Salary",
						"Get Monthly Salary",
						"Get Bonus"
				);
		final ComboBox payOps = new ComboBox(payOptions);
		
		Button salary = new Button("Calculate Salary");
		salary.setOnAction(e->{
			Employee temp = (Employee )empList2.getValue();
			IEmployee employeeCheck = new Payroll(temp);

			switch (payOps.getValue().toString()){
				case("Get Salary"):
					employeeCheck.CalculateSalary();
					feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateSalary() + " an hour");
					break;
				case("Get Weekly Salary"):
					employeeCheck.CalculateWeeklySalary();
					feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateWeeklySalary() + " a week");
					break;
				case("Get Monthly Salary"):
					temp.CalculateMonthlySalary();
					feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateMonthlySalary() + " a Month");
					break;
				case("Get Bonus"):
					employeeCheck.CalculateBonusSalary(temp.getIsCeo());
					feedbackText.setText(temp.getName() + " earns " + employeeCheck.CalculateBonusSalary(temp.getIsCeo()) + " for bonus pay");
					break;
			}
		});
		
		Label empNameLabel2 = new Label("Employee  name");
		Label payType = new Label("Pay Type");
		
		/*
			Code to Add existing Employee to a carpool
		 */
		ObservableList<String> carPools =
				FXCollections.observableArrayList(
						"CarPool1",
						"CarPool2",
						"CarPool3"
				);
		Label name = new Label("Employee Name");
		Label carPoolLabel = new Label("Car Pools");
		
		ComboBox carpool = new ComboBox(carPools);
		ComboBox carPoolNames = new ComboBox(employees);
		carPoolNames.setMaxWidth(100);
		
		Button addToCarPool = new Button("Add To Car Pool");
		
		addToCarPool.setOnAction(e->{
			switch (carpool.getValue().toString()){
				case("CarPool1"):
					cp1.add((Employee) carPoolNames.getValue());
					break;
				case("CarPool2"):
					cp2.add((Employee) carPoolNames.getValue());
					break;
				case("CarPool3"):
					cp3.add((Employee) carPoolNames.getValue());
					break;
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
		root.add(submit, 4, 2);
		root.add(empNameToFindLabel, 0, 4);
		root.add(findListOptions, 0, 5);
		root.add(find, 1, 5);
		root.add(empNameLabel, 0, 6);
		root.add(empList, 0, 7);
		root.add(updateField, 1, 7);
		root.add(updateAddress, 2, 7);
		root.add(updatePay, 3, 7);
		root.add(empNameLabel2, 0,8);
		root.add(payType, 1, 8);
		root.add(empList2, 0, 9);
		root.add(payOps, 1, 9);
		root.add(salary, 2, 9);
		root.add(carPoolLabel, 0, 10);
		root.add(name, 1, 10);
		root.add(carpool, 0, 11);
		root.add(carPoolNames, 1, 11);
		root.add(addToCarPool, 2, 11);
		root.add(feedbackText, 0,12, 10, 1);
		
		this.getChildren().addAll(root);
	}
}
