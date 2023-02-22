package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {

    @Override
    public void stop() {
        System.out.println("In stop");    
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parser parser = new Parser();
        List<Employee> employeeList = parser.parse(ReadFile.read());
        employeeList.forEach(System.out::println);

        TableView tableView = new TableView();

        TableColumn<Employee, String> column1 =
                new TableColumn<>("Name");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> column2 =
                new TableColumn<>("Surname");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("surname"));

        TableColumn<Employee, String> column3 =
                new TableColumn<>("Email");

        column3.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        TableColumn<Employee, String> column4 =
                new TableColumn<>("Id_number");

        column4.setCellValueFactory(
                new PropertyValueFactory<>("numberId"));



        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);


        for (Employee employee : employeeList) {
            tableView.getItems().add(
                    employee);
        }


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
