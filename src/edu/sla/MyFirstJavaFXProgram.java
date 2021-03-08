package edu.sla;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class MyFirstJavaFXProgram extends Application {

    Image image;
    Image image2;
    Image image3;
    Image image4;
    Image image5;
    Image image6;
    ImageView imageView;


    public static void main(String[] args) {
	// write your code here
        Application.launch(args);
    }


    public void userClickedItem1(){

    }

    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Wassup");

        MenuItem menuItem1 = new MenuItem("Main Menu");
        MenuItem menuItem2 = new MenuItem("Options");
        MenuItem menuItem3 = new MenuItem("About me");

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setImage(image);
            }
        });

        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setImage(image2);
            }
        });

        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setImage(image3);
            }
        });

        MenuButton menuButton = new MenuButton("", null, menuItem1, menuItem2, menuItem3);

        //create UIElements
        FileInputStream input = new FileInputStream("/Users/jacobprunes/Downloads/HomeButton.png");
        image = new Image(input);
        imageView = new ImageView(image);


        FileInputStream input2 = new FileInputStream("/Users/jacobprunes/Downloads/Options.png");
        image2 = new Image(input2);

        FileInputStream input3 = new FileInputStream("/Users/jacobprunes/Downloads/Person.png");
        image3 = new Image(input3);

        FileInputStream input4 = new FileInputStream("/Users/jacobprunes/Downloads/Plus.png");
        image4 = new Image(input4);

        FileInputStream input5 = new FileInputStream("/Users/jacobprunes/Downloads/Minus.png");
        image5 = new Image(input5);



        menuButton.setGraphic(imageView);

        RadioButton radioButton1 = new RadioButton("Add");
        RadioButton radioButton2 = new RadioButton("Minus");

        radioButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setImage(image4);
            }
        });

        radioButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setImage(image5);
            }
        });

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);

        FileChooser fileChooser = new FileChooser();

        Button button = new Button("Select File");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            try {
                FileInputStream input6 = new FileInputStream(selectedFile);
                image6 = new Image(input6);
                imageView.setImage(image6);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        TextField textField = new TextField();
        Label label = new Label();
        Label label2 = new Label();

        Button buttontext = new Button("Click to get text");
        buttontext.setOnAction(action -> {
            System.out.println(textField.getText());
            label.setText(textField.getText());
        });

        DatePicker datePicker = new DatePicker();

        Button button2 = new Button("Read Date");

        button.setOnAction(actionEvent -> {
            LocalDate value = datePicker.getValue();
        });


        ListView listView = new ListView();


        listView.getItems().add(label);
        listView.getItems().add(datePicker);
        listView.getItems().add(label2);


        Button clearbutton = new Button("Clear");
        clearbutton.setOnAction(actionEvent -> {
            label.setText(" ");
        });

        listView.getItems().add(clearbutton);



        // create layout
        HBox myLayout = new HBox(menuButton, radioButton1, radioButton2, button, textField, buttontext, label, datePicker, listView);

        // create Scene
        Scene myScene = new Scene( myLayout);
        stage.setScene(myScene);

        stage.setWidth(1000);
        stage.setWidth(1000);



        //Display scene
        stage.show();
    }
}
