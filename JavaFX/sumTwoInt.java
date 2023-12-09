import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.event.*;


public class sumTwoInt extends Application {
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
		t1.setPrefColumnCount(3);


		l2 = new Label("Integer 2: ");
		t2 = new TextField();
		t2.setPromptText("Enter int 2");
		t2.setPrefColumnCount(3);

		b1 = new Button("Compute sum");

		response = new Label();

		b1.setOnAction(ae -> {
			int a = Integer.parseInt(t1.getText());
			int b = Integer.parseInt(t2.getText());
			double sum = a + b;
			String res = Double.toString(sum);
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