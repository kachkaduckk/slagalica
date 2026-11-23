package com.example.slagalica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class SlagalicaController {
    static int missesCount = 0;
    static int movesCount = 0;
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
    @FXML
    private Button bt16;
    @FXML
    private Button bt17;
    @FXML
    private Button bt18;
    @FXML
    private Button bt19;
    @FXML
    private Button bt20;
    @FXML
    private Button bt21;
    @FXML
    private Button bt22;
    @FXML
    private Button bt23;
    @FXML
    private Button bt24;
    @FXML
    private Button bt25;
    @FXML
    private Button bt26;
    @FXML
    private Button bt27;
    @FXML
    private Button bt28;
    @FXML
    private Button bt29;
    @FXML
    private Button bt30;
    @FXML
    private Button bt31;
    @FXML
    private Button bt32;
    @FXML
    private Button bt33;
    @FXML
    private Button bt34;
    @FXML
    private Button bt35;




    Button[] buttons1 = new Button[36];
    List<Button> buttons;
    Button[] buttons2 = new Button[] {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35 };

    @FXML
    public void initialize(){
        buttons1 = new Button[] {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35 };
        buttons = Arrays.asList(buttons1);
        buttons2 = new Button[] {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35 };
    }

    @FXML
    private void restartButton(ActionEvent e){
        Collections.shuffle(buttons);
        for (int i = 0; i < 36; i++) {
            Button gumb = buttons.get(i);
            if (i==0){
                gumb.setText("");
                continue;
            }
            gumb.setText(String.valueOf(i));
        }
        missesCount=0;
        movesCount=0;
        moves.setText("0");
        misses.setText("0");
    }

    private int findPosition(Button gumb) {
        String id = gumb.getId();
        String position = id.replace("bt", "");
        return Integer.parseInt(position);
    }

    @FXML
    private void numButton(ActionEvent e){
        // kako bi rjesenje bilo univerzalno moramo doci do broja redaka i stupaca
        double buttonsQuantity = (double) (buttons.toArray().length);
        int dimension = (int) Math.pow(buttonsQuantity, 0.5);
        //trazimo poziciju kliknutog i poziciju praznog
        Button clickedButton = (Button) e.getSource();
        int idClicked = findPosition(clickedButton);
        Button emptyButton = null;
        for (Button b : buttons) {
            if (b.getText().isEmpty()) {
                emptyButton = b;
                break;
            }
        }
        int idEmpty = findPosition(emptyButton);
        //pozicije su poznate, trazimo retkove i stupce za rijesenje problema
        int rowClicked = idClicked / dimension;
        int rowEmpty = idEmpty / dimension;
        int columnClicked = idClicked % dimension;
        int columnEmpty = idEmpty % dimension;

        if (((idClicked + 1) == idEmpty && rowClicked == rowEmpty) ||
        ((idClicked - 1) == idEmpty && rowClicked == rowEmpty) ||
        ((idClicked + dimension) == idEmpty && columnClicked == columnEmpty) ||
        ((idClicked - dimension) == idEmpty && columnClicked == columnEmpty))
        {
            emptyButton.setText(clickedButton.getText());
            clickedButton.setText("");
        }
        else{
            missesCount++;
        }
        movesCount++;
        moves.setText(String.valueOf(movesCount));
        misses.setText(String.valueOf(missesCount));
        winCheck();
    }

    private void winCheck(){
        for (int i = 0; i < buttons1.length-1; i++) {
            String text = buttons1[i].getText();
            if (!(text.equals(String.valueOf(i+1)))){
                return;
            }
        }
        System.out.println("YOU WON!");
    }
}
