package com.example.tictactoefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TTTController {
    @FXML
    private Button button;

    @FXML
    private int changer = 2;
    @FXML
    private int buttonNumbers = 0;
    @FXML
    private String inputValue;
    @FXML
    private Label text;
    @FXML
    private Label player;
    @FXML
    private Label warning;
    @FXML
    List<String> playerPositions = new ArrayList<>();
    @FXML
    List<String> cpuPositions = new ArrayList<>();
    @FXML
    List<String> selectedPosition = new ArrayList<>();
    @FXML
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    @FXML
    private List<Button> buttons = Arrays.asList(button1,
            button2, button3, button4, button5, button6, button7, button8, button9);

    @FXML
    List<Button> buttons2 = new ArrayList<>();

    @FXML
    public void onHelloButtonClick(ActionEvent e) {
        if (buttonNumbers < 9) {
            this.button = buttons.get(buttonNumbers);
            this.button = new Button();
            inputValue = ((Button) e.getSource()).getId();
            this.button = ((Button) e.getTarget());
            buttons2.add(this.button);
            setPlayerSymbol(e);

            changer++;
            buttonNumbers++;
        }else if(buttonNumbers==9 &&checkWinner(playerPositions)==false&&checkWinner(cpuPositions)==false){
            warning.setText("No winner !");
        }
    }

    public void setPlayerSymbol(ActionEvent e) {
        if (changer % 2 == 0) {
            warning.setText("Order : Player 2 Symbol 0");

            playerPositions.add(inputValue);
            ((Button) e.getSource()).setText("X");
            ((Button) e.getSource()).setTextFill(Paint.valueOf("red"));

            if (isEnd()) {
                clean();
            }
            if (checkWinner(playerPositions)) {
                warning.setText("Player 1 Wins!");
                buttonNumbers=9;
            }


        } else {
            warning.setText("Order : Player 1 Symbol X");
            cpuPositions.add(inputValue);

            ((Button) e.getSource()).setText("0");
            ((Button) e.getSource()).setTextFill(Paint.valueOf("blue"));
            if (isEnd()) {
                clean();
            }
            if (checkWinner(cpuPositions)) {
                warning.setText("Player 2 Wins!");
                buttonNumbers=9;
            }

        }

    }


    public boolean checkWinner(List list) {

        List list1 = Arrays.asList("1", "2", "3");
        List list2 = Arrays.asList("4", "5", "6");
        List list3 = Arrays.asList("7", "8", "9");
        List list4 = Arrays.asList("1", "4", "7");
        List list5 = Arrays.asList("2", "5", "8");
        List list6 = Arrays.asList("3", "6", "9");
        List list7 = Arrays.asList("1", "5", "9");
        List list8 = Arrays.asList("3", "5", "7");
        List list9 = Arrays.asList("3", "2", "1");
        List list10 = Arrays.asList("6", "5", "4");
        List list11 = Arrays.asList("9", "8", "7");
        List list12 = Arrays.asList("7", "4", "1");
        List list13 = Arrays.asList("8", "5", "2");
        List list14 = Arrays.asList("9", "6", "3");
        List list15 = Arrays.asList("9", "5", "1");
        List list16 = Arrays.asList("7", "5", "3");


        List<List> winner = new ArrayList<List>();
        winner.add(list1);
        winner.add(list2);
        winner.add(list3);
        winner.add(list4);
        winner.add(list5);
        winner.add(list6);
        winner.add(list7);
        winner.add(list8);
        winner.add(list9);
        winner.add(list10);
        winner.add(list11);
        winner.add(list12);
        winner.add(list13);
        winner.add(list14);
        winner.add(list15);
        winner.add(list16);

        // Checking if the player's list is in the big list.
        for (List k : winner) {
            if (list.containsAll(k)) {
                return true;
            }
        }

        return false;
    }


    public boolean isEnd() {
        if (this.selectedPosition.size() == 9) {
            warning.setText("No winner !");
            return true;
        }
        return false;
    }


    public void clean() {
        warning.setText("Order : Player 1 Symbol X");
        this.changer = 2;
        this.selectedPosition.clear();
        this.buttonNumbers = 0;
        this.cpuPositions.clear();
        this.playerPositions.clear();
        buttonClear(buttons2);
        buttons2.clear();


    }


    public void buttonClear(List<Button> buttons) {
        for (Button b : buttons) {
            b.setText("");
        }
    }

}
