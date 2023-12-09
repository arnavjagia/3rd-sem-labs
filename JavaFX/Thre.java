// import javafx.animation.Animation;
// import javafx.animation.KeyFrame;
// import javafx.animation.Timeline;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.RadioButton;
// import javafx.scene.control.ToggleGroup;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.StackPane;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class Thre extends Application {

//     private final String message = "Hello, this is a scrolling message!";
//     private final Text messageText = new Text(message);

//     @Override
//     public void start(Stage primaryStage) {
//         // Set up UI components
//         StackPane root = new StackPane();
//         HBox hbox = new HBox(10);

//         // Create radio buttons
//         ToggleGroup directionGroup = new ToggleGroup();
//         RadioButton leftToRightRadioButton = new RadioButton("Left to Right");
//         RadioButton rightToLeftRadioButton = new RadioButton("Right to Left");

//         leftToRightRadioButton.setToggleGroup(directionGroup);
//         rightToLeftRadioButton.setToggleGroup(directionGroup);

//         // Default direction
//         leftToRightRadioButton.setSelected(true);

//         // Create message scroll thread
//         Thread scrollThread = new Thread(() -> {
//             while (true) {
//                 try {
//                     Thread.sleep(50); // Adjust the speed of scrolling
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }

//                 // Update the message position based on the selected direction
//                 if (leftToRightRadioButton.isSelected()) {
//                     messageText.setTranslateX(messageText.getTranslateX() + 1);
//                 } else {
//                     messageText.setTranslateX(messageText.getTranslateX() - 1);
//                 }
//             }
//         });

//         // Create timeline for JavaFX animation
//         Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
//             // Update the message position based on the selected direction
//             if (leftToRightRadioButton.isSelected()) {
//                 messageText.setTranslateX(messageText.getTranslateX() + 1);
//             } else {
//                 messageText.setTranslateX(messageText.getTranslateX() - 1);
//             }
//         }));

//         timeline.setCycleCount(Animation.INDEFINITE);
//         timeline.play();

//         // Add components to the scene
//         hbox.getChildren().addAll(leftToRightRadioButton, rightToLeftRadioButton);
//         root.getChildren().addAll(messageText, hbox);

//         // Set up the stage
//         Scene scene = new Scene(root, 400, 100);
//         primaryStage.setTitle("Message Scroll App");
//         primaryStage.setScene(scene);
//         primaryStage.show();

//         // Start the scroll thread
//         //scrollThread.start();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// public class Thre extends Application {

//     private Canvas canvas;
//     private CheckBox englishCheckbox;
//     private CheckBox spanishCheckbox;
//     private CheckBox frenchCheckbox;

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Resume Builder");

//         // Create UI components
//         englishCheckbox = new CheckBox("English");
//         spanishCheckbox = new CheckBox("Spanish");
//         frenchCheckbox = new CheckBox("French");

//         Button submitButton = new Button("Submit");
//         submitButton.setOnAction(e -> displayResume());

//         canvas = new Canvas(400, 200);

//         // Create layout
//         VBox layout = new VBox(10);
//         layout.getChildren().addAll(englishCheckbox, spanishCheckbox, frenchCheckbox, submitButton, canvas);

//         // Set up the scene
//         Scene scene = new Scene(layout, 400, 300);
//         primaryStage.setScene(scene);

//         primaryStage.show();
//     }

//     private void displayResume() {
//         // Clear the canvas
//         GraphicsContext gc = canvas.getGraphicsContext2D();
//         // gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

//         // Display resume details
//         gc.fillText("Resume", 10, 20);
//         gc.fillText("Languages:", 10, 40);

//         // Check which languages are selected and display them
//         if (englishCheckbox.isSelected()) {
//             gc.fillText("- English", 20, 60);
//         }
//         if (spanishCheckbox.isSelected()) {
//             gc.fillText("- Spanish", 20, 80);
//         }
//         if (frenchCheckbox.isSelected()) {
//             gc.fillText("- French", 20, 100);
//         }
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }


public class Thre extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    GraphicsContext gc;

    public void start(Stage stage) {
        stage.setTitle(STYLESHEET_CASPIAN);
        FlowPane fp = new FlowPane(20, 20);
        Scene sc = new Scene(fp, 720, 480);
        ObservableList<String> items = FXCollections.observableArrayList("A", "B", "C");
        ListView<String> lv = new ListView<>(items);

        Canvas c = new Canvas(400, 200);
        gc = c.getGraphicsContext2D();

        lv.getSelectionModel().selectedItemProperty().addListener((changed, oldVal, newVal) -> {
            gc.clearRect(0, 0, c.getWidth(), c.getHeight());
            gc.fillText("Selected: " + newVal, 10, 10);
            
        });

        fp.getChildren().addAll(lv, c);
        stage.setScene(sc);
        stage.show();
    }
}