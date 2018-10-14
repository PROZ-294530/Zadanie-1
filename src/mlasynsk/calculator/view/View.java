package mlasynsk.calculator.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import mlasynsk.calculator.model.Model;

public class View implements Initializable {
	TextField textField;

	public View(TextField textField) {
		this.textField = textField;
	}

	public void display(Model model) {
		textField.setText(model.getValue());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void showAlert() {
		showAlert("Can't process the expression!");
	}

	public void showAlert(String string) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(string);
		alert.show();

	}
}
