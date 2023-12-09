import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.event.*;

class Sum implements Runnable {
    Thread thrd;
    int a, b, sum;

    Sum(int a, int b) {
        this.a = a; this.b = b;
        thrd = new Thread(this);
        thrd.start();
    }

    @Override
    public void run() {
        sum = a+b;
    }
    
}

public class sumMulti extends Application {
	Label l1, l2, response;
	TextField t1, t2;
	Button b1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Add two integers");
		FlowPane rootnode = new FlowPane(10,10);
		rootnode.setAlignment(Pos.CENTER);
		Scene scene = new Scene(rootnode, 300, 200);
		stage.setScene(scene);
		
		l1 = new Label("Integer 1: ");
		t1 = new TextField();
		t1.setPromptText("Enter int 1");

		l2 = new Label("Integer 2: ");
		t2 = new TextField();
		t2.setPromptText("Enter int 2");

		b1 = new Button("Compute sum");

		response = new Label();
		b1.setOnAction(ae -> {
		    int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            Sum th = new Sum(a, b);
            try{ th.thrd.join(); } catch (InterruptedException e) { e.printStackTrace(); }
            int sum = th.sum;
            String res = Integer.toString(sum);
            response.setText("Sum: " + res);
		});

		rootnode.getChildren().addAll(l1, t1, l2, t2, b1, response);

		stage.show();
	}
}

/*
javac --module-path $env:FXPATH --add-modules javafx.controls sumTwoInt.java
java --module-path $env:FXPATH --add-modules javafx.controls sumTwoInt
*/
