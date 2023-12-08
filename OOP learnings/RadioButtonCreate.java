import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.geometry.*;

public class RadioButtonCreate extends Application {
    RadioButton rb1, rb2, rb3;
    ToggleGroup tg;
    Label response;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Aata hai bro");
        FlowPane fp = new FlowPane(10, 10);
        fp.setAlignment(Pos.CENTER);
        Scene sc = new Scene(fp, 400, 300);
        stage.setScene(sc);

        rb1 = new RadioButton("Button 1");
        rb2 = new RadioButton("Button 2");
        rb3 = new RadioButton("Button 3");
        tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);

        rb3.fire();                                                         // note fire()
        rb2.setSelected(true);                                              // note setSelected()
        String res = "Button selected: ";
        response = new Label(res);
        rb1.setOnAction(ae -> {
            System.out.println(rb1.getText());
            response.setText(res + "1");
        });
        rb2.setOnAction(ae -> {
            System.out.println(rb2.getText());
            response.setText(res + "2");
        });
        rb3.setOnAction(ae -> {
            System.out.println(rb3.getText());
            response.setText(res + "3");
        });
        fp.getChildren().addAll(rb1, rb2, rb3, response);
        stage.show();
    }
}
