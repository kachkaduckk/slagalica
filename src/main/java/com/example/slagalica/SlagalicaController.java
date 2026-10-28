package com.example.slagalica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SlagalicaController {
    @FXML
    private TextArea moves;
    @FXML
    private TextArea misses;
    @FXML
    private Button bt0;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button bt10;
    @FXML
    private Button bt11;
    @FXML
    private Button bt12;
    @FXML
    private Button bt13;
    @FXML
    private Button bt14;
    @FXML
    private Button bt15;
    Random random = new Random();
    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};
    Button[] buttons1 = new Button[16];
    List<Button> buttons;

    @FXML
    public void initialize(){
        buttons1 = new Button[] {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15};
        buttons = Arrays.asList(buttons1);
    }

    @FXML
    private void restartButton(ActionEvent e){
        Collections.shuffle(buttons);
        for (int i = 0; i < 16; i++) {
            Button gumb = buttons.get(i);
            if (i==0){
                gumb.setText("");
                continue;
            }
            gumb.setText(String.valueOf(i));
        }
    }

    @FXML
    private void numButton(ActionEvent e){
        Button gumb = (Button) e.getSourse();

    }
}
