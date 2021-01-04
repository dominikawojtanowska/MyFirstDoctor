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

public class SymptomPane extends Pane {
    private SymptomLeaf leaf;
    private Stage primaryStage;
    private Text question;
    private SymptomNode[] nodes;
    private static Font font = Font.font("Gabriola", 30);;

    SymptomPane(Stage primaryStage){
        this.primaryStage = primaryStage;
        startPane();
        init();
    }

    SymptomPane(Stage primaryStage, SymptomLeaf leaf){
        this.primaryStage = primaryStage;
        this.leaf = leaf;
        init();
    }

    private void startPane(){
        leaf = SymptomLeaf.firstLeaf;
    }

    private void init(){
        this.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, new Insets(0,0,0,0))));
        question = new Text(10,10,leaf.getQuestion());
        question.setFont(font);
        question.setSmooth(true);
        question.setWrappingWidth(260);
        question.setX(20); question.setY(50);
        question.setTextAlignment(TextAlignment.CENTER);
        nodes = leaf.getNodes();
        for(int i=0 ; i<nodes.length; i++){
            Button button = new Button();
            button.setText(nodes[i].name);
            button.setPrefSize(150,20);
            button.setLayoutY(150 + i * 40);
            button.setLayoutX(75);
            int finalI = i;
            if(nodes[i].child.getNodes() == null){
                button.setOnAction(e-> {
                    System.out.print(nodes[finalI].child.getName());
                    ReferralPane rp = null;
                    rp = new ReferralPane(primaryStage, nodes[finalI].child.getName());
                    primaryStage.setScene(new Scene(rp, 300, 450));
                });
            }
            else{
                button.setOnAction(e-> {
                    SymptomPane sp = new SymptomPane(primaryStage, nodes[finalI].child);
                    primaryStage.setScene(new Scene(sp, 300, 450));
                });
            }
            this.getChildren().add(button);
        }
        this.getChildren().add(question);
    }

}
