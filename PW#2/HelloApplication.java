package com.example.p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Text label1 = new Text("Площа трикутника зi сторонами a, b, c");
        label1.setLayoutX(50);
        label1.setLayoutY(50);

        Text label2 = new Text("Трикутник:");
        label2.setLayoutX(80);
        label2.setLayoutY(80);

        Text labela = new Text("a:");
        labela.setLayoutX(65);
        labela.setLayoutY(105);

        TextField tfa = new TextField();
        tfa.setLayoutX(80);
        tfa.setLayoutY(90);

        Text labelb = new Text("b:");
        labelb.setLayoutX(65);
        labelb.setLayoutY(135);

        TextField tfb = new TextField();
        tfb.setLayoutX(80);
        tfb.setLayoutY(120);

        Text labelc = new Text("c:");
        labelc.setLayoutX(65);
        labelc.setLayoutY(165);

        TextField tfc = new TextField();
        tfc.setLayoutX(80);
        tfc.setLayoutY(150);

        Group groupinput = new Group(label2, labela, tfa, labelb, tfb, labelc, tfc);


        Button button = new Button("Обчислити");
        button.setLayoutX(80);
        button.setLayoutY(180);

        Text labelres = new Text("Результат:");
        labelres.setLayoutX(80);
        labelres.setLayoutY(240);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    labelres.setText("");

                    if(tfa.getText().isEmpty()) throw new Exception("Введіть сторону а!");
                    if(tfb.getText().isEmpty()) throw new Exception("Введіть сторону b!");
                    if(tfc.getText().isEmpty()) throw new Exception("Введіть сторону c!");

                    int a = Integer.parseInt(tfa.getText());
                    int b = Integer.parseInt(tfb.getText());
                    int c = Integer.parseInt(tfc.getText());

                    if(a <= 0) throw new Exception("Сторона a має бути більше за 0!");
                    if(b <= 0) throw new Exception("Сторона b має бути більше за 0!");
                    if(c <= 0) throw new Exception("Сторона c має бути більше за 0!");

                    double p = (a+b+c) / 2f;
                    double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));

                    if(s == 0 || Double.isNaN(s)) throw new Exception("Такого трикутника не існує!");

                    labelres.setText(String.format("Площа: %.2f", s));

                }
                catch (NumberFormatException e)
                {
                    labelres.setText("Невірний тип даних!");
                }
                catch (Exception e)
                {
                    labelres.setText(e.getMessage());
                }
            }
        });

        Group group = new Group(label1, label2, groupinput, button, labelres);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Практична 2. Савицький Олександр");
        stage.setWidth(300);
        stage.setHeight(300);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}