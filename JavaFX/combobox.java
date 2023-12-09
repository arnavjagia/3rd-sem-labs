import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.paint.*;
import javafx.collections.*;

public class combobox extends Application {
	ComboBox<String> cbx;	
	Label response;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		System.out.println("Inside init()"
				+ " Thread: " + Thread.currentThread().getName());
	}
	@Override
	public void start(Stage stage) {
		stage.setTitle("ComboBox Demo");
		FlowPane rootnode = new FlowPane(10, 10);
		rootnode.setAlignment(Pos.CENTER);
		Scene scene = new Scene(rootnode, 300, 200);
		stage.setScene(scene);

		System.out.println("Thread: " + Thread.currentThread().getName());;

		response = new Label("Test Label");
		ObservableList<String> ol = FXCollections.observableArrayList("hello", "world", "test", "demo");
		cbx = new ComboBox<>(ol);
		cbx.setValue("hello");
		// response.setText(cbx.getValue());
		cbx.setOnAction(ae -> {
			response.setText(cbx.getValue());
			System.out.println("Selected: " + cbx.getValue());
		});
		rootnode.getChildren().addAll(cbx, response);
		stage.show();
	}
	@Override
	public void stop() {
		System.out.println("Inside stop()");
	}

}

/*

javac --module-
*/