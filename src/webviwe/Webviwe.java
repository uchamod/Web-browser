
package webviwe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Webviwe extends Application {
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Image img=new Image("doge.png"); 
        Scene scene = new Scene(root);
        //Image icon=new Image("D:/apple.png");
        stage.getIcons().add(img);
        stage.setTitle("Doge Browse V2");
        stage.setScene(scene);
        stage.show();
    }

   
    
    
}
