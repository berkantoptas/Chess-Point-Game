package com.berkan;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class AppController implements Initializable {

    @FXML
    private AnchorPane anchorPane_App;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button buttonSelectInputFile_App;

    @FXML
    private Label labelResult_App;

    private Pieces[][] board = new Pieces[8][8];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void actionSelectInputFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt files", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            InitializeBoard(file.getAbsolutePath());
            CheckThreats();
            DrawBoard();
            PrintResult();
        }
    }

    private void InitializeBoard(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        for(int i = 0 ; i < 8 ; i++){
            String[] pieces = scanner.nextLine().split(" ");
            for(int j = 0 ; j < 8 ; j++){
                if(pieces[j].equals("--")){
                    board[i][j] = null;
                }
                if(pieces[j].charAt(1) == 'b'){
                    if(pieces[j].charAt(0) == 'p')
                        board[i][j] = new Pawn(0, i, j);
                    else if(pieces[j].charAt(0) == 'a')
                        board[i][j] = new Knight(0, i, j);
                    else if(pieces[j].charAt(0) == 'f')
                        board[i][j] = new Bishop(0, i, j);
                    else if(pieces[j].charAt(0) == 'k')
                        board[i][j] = new Rook(0, i, j);
                    else if(pieces[j].charAt(0) == 'v')
                        board[i][j] = new Queen(0, i, j);
                    else if(pieces[j].charAt(0) == 's')
                        board[i][j] = new King(0, i, j);
                }
                else if(pieces[j].charAt(1) == 's'){
                    if(pieces[j].charAt(0) == 'p')
                        board[i][j] = new Pawn(1, i, j);
                    else if(pieces[j].charAt(0) == 'a')
                        board[i][j] = new Knight(1, i, j);
                    else if(pieces[j].charAt(0) == 'f')
                        board[i][j] = new Bishop(1, i, j);
                    else if(pieces[j].charAt(0) == 'k')
                        board[i][j] = new Rook(1, i, j);
                    else if(pieces[j].charAt(0) == 'v')
                        board[i][j] = new Queen(1, i, j);
                    else if(pieces[j].charAt(0) == 's')
                        board[i][j] = new King(1, i, j);
                }
            }
        }
        scanner.close();
    }

    private void CheckThreats(){
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(board[i][j] == null)
                    continue;
                board[i][j].checkThreats(board);
            }
        }
    }

    private void DrawBoard(){
        String img;
        boolean hasBorder;
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(board[i][j] == null){
                    Button b = new Button("");
                    b.setMinHeight(80);
                    b.setMinWidth(80);
                    String style = "";
                    if((i % 2 == 0) && (j % 2 == 0))
                        style = "-fx-background-color: #f0d9b5;";
                    else if((i % 2 == 1) && (j % 2 == 1))
                        style = "-fx-background-color: #f0d9b5;";
                    else if((i % 2 == 0) && (j % 2 == 1))
                        style = "-fx-background-color: #b58863;";
                    else if((i % 2 == 1) && (j % 2 == 0))
                        style = "-fx-background-color: #b58863;";
                    b.setStyle(style);
                    gridPane.add(b, j, i);
                    continue;
                }
                img = "";
                hasBorder = false;
                if(board[i][j].isThreatened)
                    hasBorder = true;
                if(board[i][j].color == 0){
                    if(board[i][j].name.equals("pawn"))
                        img = "whitepawn_80x80.png";
                    else if(board[i][j].name.equals("bishop"))
                        img = "whitebishop_80x80.png";
                    else if(board[i][j].name.equals("rook"))
                        img = "whiterook_80x80.png";
                    else if(board[i][j].name.equals("queen"))
                        img = "whitequeen_80x80.png";
                    else if(board[i][j].name.equals("king"))
                        img = "whiteking_80x80.png";
                    else if(board[i][j].name.equals("knight"))
                        img = "whiteknight_80x80.png";
                }
                else if(board[i][j].color == 1){
                    if(board[i][j].name.equals("pawn"))
                        img = "blackpawn_80x80.png";
                    else if(board[i][j].name.equals("bishop"))
                        img = "blackbishop_80x80.png";
                    else if(board[i][j].name.equals("rook"))
                        img = "blackrook_80x80.png";
                    else if(board[i][j].name.equals("queen"))
                        img = "blackqueen_80x80.png";
                    else if(board[i][j].name.equals("king"))
                        img = "blackking_80x80.png";
                    else if(board[i][j].name.equals("knight"))
                        img = "blackknight_80x80.png";
                }
                Button b = new Button("");
                b.setMinHeight(80);
                b.setMinWidth(80);
                if(img.equals("whiteknight_80x80.png") || img.equals("whitepawn_80x80.png"))
                    b.setGraphic(new ImageView(new Image(getClass().getResource(img).toExternalForm(),60,70,false,true)));
                else
                    b.setGraphic(new ImageView(new Image(getClass().getResource(img).toExternalForm(),80,80,false,true)));
                String style = "";
                if((i % 2 == 0) && (j % 2 == 0))
                    style = "-fx-background-color: #f0d9b5;";
                else if((i % 2 == 1) && (j % 2 == 1))
                    style = "-fx-background-color: #f0d9b5;";
                else if((i % 2 == 0) && (j % 2 == 1))
                    style = "-fx-background-color: #b58863;";
                else if((i % 2 == 1) && (j % 2 == 0))
                    style = "-fx-background-color: #b58863;";
                b.setStyle(style);
                if(hasBorder)
                    b.setStyle(style + "-fx-border-color:red;-fx-border-width: 5;");
                gridPane.add(b, j, i);
            }
        }
    }

    private void PrintResult(){
        Platform.runLater(new Runnable() {
            public void run() {
                double whitePoints = 0;
                double blackPoints = 0;
                for(int i = 0 ; i < 8 ; i++){
                    for(int j = 0 ; j < 8 ; j++){
                        if(board[i][j] == null)
                            continue;
                        if(board[i][j].color == 0){
                            if(!board[i][j].isThreatened)
                                whitePoints += board[i][j].point;
                            else
                                whitePoints += board[i][j].point / 2;
                        }
                        else if(board[i][j].color == 1){
                            if(!board[i][j].isThreatened)
                                blackPoints += board[i][j].point;
                            else
                                blackPoints += board[i][j].point / 2;
                        }
                    }
                }
                labelResult_App.setText("White's total score: " + whitePoints + "\nBlack's total score: " + blackPoints);
            }
        });
    }
}
