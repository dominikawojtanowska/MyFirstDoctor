package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ReferralPane extends Pane {
    private String referral;

    ReferralPane(Stage stage, String referral){
        this.referral = referral;
        this.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, new Insets(0,0,0,0))));
        Text text = new Text("Referral to: " );
        Text refText = new Text(referral);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setY(50); text.setX(50);
        text.setWrappingWidth(200);
        text.setFont(Font.font("Gabriola", 30));

        refText.setTextAlignment(TextAlignment.CENTER);
        refText.setY(200); refText.setX(50);
        refText.setWrappingWidth(200);
        refText.setFont(Font.font("Gabriola", 60));

        Button button = new Button("Again");
        button.setOnAction(e-> {
            SymptomPane pane = new SymptomPane(stage);
            Scene scene = new Scene(pane, 300, 450);
            stage.setScene(scene);
        });
        button.setPrefSize(50,40);
        button.setLayoutY(410); button.setLayoutX(250);
        this.getChildren().addAll(text, refText, button);
    }
}
