package org.example.jfxclass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReverseController {

    @FXML private TextField txtInput;
    @FXML private Label lbResultText;

    public void reverse(ActionEvent actionEvent) {
        final String input = txtInput.getText();
        StringBuilder sb = new StringBuilder(input);
        final String reversedInput = sb.reverse().toString();
        lbResultText.setText(reversedInput);
        InfoView view = new InfoView();
        view.show(reversedInput.length());
    }
}
