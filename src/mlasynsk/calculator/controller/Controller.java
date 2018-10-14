package mlasynsk.calculator.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import jdk.jshell.JShell;
import jdk.jshell.Snippet.Status;
import jdk.jshell.SnippetEvent;
import mlasynsk.calculator.model.Model;
import mlasynsk.calculator.view.View;

public class Controller implements Initializable {

	private View view;
	private Model model;

	@FXML
	TextField textField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textField.setEditable(false);
		view = new View(textField);
		model = new Model();
	}

	@FXML
	private void handleRegularEvent(ActionEvent event) {
		Labeled labeled = (Labeled) event.getSource();
		model.addValue(labeled.getText());
		view.display(model);

	}

	@FXML
	private void equals(ActionEvent event) {
		if (model.getValue().length() > 0) {
			runJshell();
		}
	}

	private void runJshell() {
		JShell jShell = JShell.create();
		List<SnippetEvent> x = jShell.eval(model.getValue());
		System.out.println(x);

		SnippetEvent snippetEvent = null;
		if (!x.isEmpty()) {
			snippetEvent = x.get(0);
		}
		if (snippetEvent != null && snippetEvent.status() == Status.VALID) {
			String expressionResult = snippetEvent.value();
			boolean canAssignExpression = model.setValue(expressionResult);
			if (canAssignExpression) {
				view.display(model);
			} else {
				view.showAlert("Expression is too long");
			}
		} else {
			view.showAlert();
		}
	}

	@FXML
	private void sqrt(ActionEvent event) {
		model.toSqrt();
		runJshell();
		view.display(model);
	}

	@FXML
	private void pow(ActionEvent event) {
		model.toPow();
		runJshell();
		view.display(model);
	}

	@FXML
	private void clear() {
		model.clear();
		view.display(model);
	}

	@FXML
	private void deleteOneSign(ActionEvent event) {
		model.deleteOneSign();
		view.display(model);
	}

}
