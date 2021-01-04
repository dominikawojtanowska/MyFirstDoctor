package sample;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainPane extends Pane {
    Stage primaryStage;
    ImageView mainButton;

    MainPane (Stage primaryStage) throws FileNotFoundException {
        this.primaryStage = primaryStage;
        mainButton();
        this.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, new Insets(0,0,0,0))));
        this.getChildren().add(mainButton);
    }

    private void mainButton() throws FileNotFoundException {
        mainButton = new ImageView(new Image(new BufferedInputStream(new FileInputStream(new File("images/main.png")))));
        mainButton.setY(50);
        ScaleTransition st1 = new ScaleTransition(Duration.millis(400) , mainButton);
        st1.setToX(1.2); st1.setToY(1.2);
        ScaleTransition st2 = new ScaleTransition(Duration.millis(400) , mainButton);
        st2.setToX(1); st2.setToY(1);
        mainButton.setOnMouseClicked(e -> {
            SymptomPane sp = new SymptomPane(primaryStage);
            Scene scene = new Scene(sp, 300, 450);
            primaryStage.setScene(scene);
        });
        mainButton.setOnMouseEntered(e-> {
            st1.play();
        });
        mainButton.setOnMouseExited(e-> {
            st2.play();
        });
    }
}
