package com.example.lab9;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void Task1(Stage stage){
        Text t1label = new Text("Знайти кількість повних хвилин,\n  що пройшли з початку доби.");
        t1label.setLayoutX(60);
        t1label.setLayoutY(40);
        t1label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Text text = new Text("Секунди:");
        text.setLayoutX(65);
        text.setLayoutY(125);

        TextField textField = new TextField();
        textField.setLayoutX(65);
        textField.setLayoutY(140);

        Text text_res = new Text("Результат:");
        text_res.setLayoutX(80);
        text_res.setLayoutY(240);

        Button button_task1 = new Button("Обчислити");
        button_task1.setLayoutX(80);
        button_task1.setLayoutY(180);
        button_task1.setOnAction(event -> {
            try{
                if(textField.getText().isEmpty()) throw new Exception("Значення не введене!");

                int n = Integer.parseInt(textField.getText());

                if(n < 60) throw new Exception("Введіть число більше 60!");

                text_res.setText("Результат: " + (n/60));
            }
            catch(NumberFormatException e)
            {
                text_res.setText("Введіть ціле число!");
            }
            catch (Exception e)
            {
                text_res.setText(e.getMessage());
            }
        });

        Group group_task1 = new Group(t1label, text, textField, text_res, button_task1);
        Scene scene_task1 = new Scene(group_task1);

        stage.setScene(scene_task1);
        stage.setTitle("ЛР 9. Завдання 1");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();
    }

    public void SetAlert(Alert.AlertType type, String title, String content)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void Task2(Stage stage) {
        Text t1label = new Text("Пошук студента по номеру");
        t1label.setLayoutX(80);
        t1label.setLayoutY(70);
        t1label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Text text_val = new Text("Номер:");
        text_val.setLayoutX(160);
        text_val.setLayoutY(140);

        TextField tbx_a = new TextField();
        tbx_a.setLayoutX(160);
        tbx_a.setLayoutY(150);

        Button button_task1 = new Button("Виконати");
        button_task1.setLayoutX(200);
        button_task1.setLayoutY(220);
        button_task1.setOnAction(event -> {
            try{
                if(tbx_a.getText().isEmpty()) throw new Exception("Значення не введене!");

                int n = Integer.parseInt(tbx_a.getText());

                switch (n) {
                    case 1 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Атвіновський Олексій");
                    case 2 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Балан Олександр");
                    case 3 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Безушко Максим");
                    case 4 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Гловацький Олексій");
                    case 5 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Демко Степан");
                    case 6 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Дзюба Данило");
                    case 7 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Дмитрійчук Філіп");
                    case 8 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Довгаль Кирило");
                    case 9 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Євинчук Павло");
                    case 10 -> SetAlert(Alert.AlertType.INFORMATION, "", "Студент: Єремій Віталій");
                    default -> SetAlert(Alert.AlertType.WARNING, "Помилка введення!", "Помилка введення");
                }
                System.out.println();
            }
            catch(NumberFormatException e)
            {
                SetAlert(Alert.AlertType.ERROR, "ПОМИЛКА!", "Введіть ціле число!");
            }
            catch (Exception e)
            {
                SetAlert(Alert.AlertType.ERROR, "ПОМИЛКА!", e.getMessage());
            }
        });

        Group group_task2 = new Group(t1label, text_val, tbx_a, button_task1);
        Scene scene_task2 = new Scene(group_task2);

        stage.setScene(scene_task2);
        stage.setTitle("ЛР 9. Завдання 2");
        stage.setWidth(540);
        stage.setHeight(380);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {


        //---------------------- Головна форма ----------------------
        Text label = new Text("Завдання:");
        label.setLayoutX(180);
        label.setLayoutY(70);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 26));

        Button button1 = new Button("Завдання 1");
        button1.setLayoutX(200);
        button1.setLayoutY(130);
        button1.setOnAction(event -> {
            Stage stage1 = new Stage();
            Task1(stage1);
        });

        Button button2 = new Button("Завдання 2");
        button2.setLayoutX(200);
        button2.setLayoutY(200);
        button2.setOnAction(event -> {
            Stage stage2 = new Stage();
            Task2(stage2);
        });

        Group group = new Group(label, button1, button2);
        Scene scene_main = new Scene(group);
        stage.setScene(scene_main);
        stage.setTitle("ЛР 9. Савицький Олександр");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}