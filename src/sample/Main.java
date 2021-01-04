package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My First Doctor");
        SymptomLeaf symptomLeaf1= new SymptomLeaf("Doctor", null, null);
        SymptomLeaf symptomLeaf2= new SymptomLeaf("horse throat", null, null);
        SymptomLeaf symptomLeaf= new SymptomLeaf("pain", null, null);
        SymptomNode sn1 = new SymptomNode("Yes", symptomLeaf, symptomLeaf1);
        SymptomNode sn2 = new SymptomNode("No", symptomLeaf, symptomLeaf2);

        symptomLeaf.addNodes(new SymptomNode[]{sn1, sn2});
        symptomLeaf2.addNodes(new SymptomNode[]{sn1});

        MainPane mainPane = new MainPane(primaryStage);
        Scene scene = new Scene(mainPane, 300, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
