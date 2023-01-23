package com.example.dictionary11;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.util.HashMap;

public class GamePageController {

    wordDictionary dictionaryList;
    @FXML
    TextField SearchWord;
    @FXML
    TextField Word;
    @FXML
    TextField Meaning;
    @FXML
    public void newWord(MouseEvent event) throws IOException {
        System.out.println("New Word added");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("New Word Adding");
        if (Word.textProperty().get().equals("") || Meaning.textProperty().get().equals("")) {
            infoAlert.setContentText("Enter some Word/Meaning to be Added");
            infoAlert.showAndWait();
        } else {
            dictionaryList.addWord(Word.textProperty().get(), Meaning.textProperty().get());
            dictionaryList.serializeMap();
            infoAlert.setContentText("New Word has Added to Dictionary");
            infoAlert.showAndWait();
        }
    }
    @FXML
    public void Search(MouseEvent event) throws IOException{
        System.out.println("Searching the Word");
        dictionaryList=new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert=new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Searching Result");
        if(SearchWord.textProperty().get().equals("")){
            infoAlert.setContentText(dictionaryList.getWordList().get("Please Enter a word for search"));
            infoAlert.showAndWait();
        }
        if(dictionaryList.getWordList().containsKey(SearchWord.textProperty().get()))
         {
            System.out.println(dictionaryList.getWordList().get(SearchWord.textProperty().get()));
            infoAlert.setContentText(dictionaryList.getWordList().get(SearchWord.textProperty().get()));
            infoAlert.showAndWait();
        }else{
            infoAlert.setContentText("The Word is not available in Dictionary");
            infoAlert.showAndWait();
    }
    }
}
