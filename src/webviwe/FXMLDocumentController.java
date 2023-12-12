package webviwe;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class FXMLDocumentController implements Initializable {

    @FXML
    private WebView webviwe;
    @FXML
    private TextField txt;
    @FXML
    private Button browes, refresh, zoomin, zoomout
            , histry,goback;
    @FXML
    private AnchorPane frame;
    
    @FXML
    private Hyperlink youtubelink,chat,google,cineru;
    

    private double zoomvalue;
    private WebEngine engin;
    private WebHistory webhistory;
    //.Image icon=new Image("D:/apple.png");
    //String home = "google.com";
    boolean first=true;
    @FXML
    private Button goforward;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zoomvalue = 1;
        engin = webviwe.getEngine();
        //txt.setText(home);
        load();
    }
    @FXML
    public void youtube(ActionEvent event) throws URISyntaxException, IOException{
    
        engin.load("http://www.youtube.com");
        txt.setText("http://www.youtube.com");
    }
     @FXML
    public void chatgpt(ActionEvent event) throws URISyntaxException, IOException{
       
        engin.load("https://www.chat.openai.com/");
        txt.setText("https://www.chat.openai.com/");
    }
     @FXML
    public void cineru(ActionEvent event) throws URISyntaxException, IOException{
       
        engin.load("https://www.cineru.lk/");
        txt.setText("https://www.cineru.lk/");
    }
     @FXML
    public void chrom(ActionEvent event) throws URISyntaxException, IOException{
       
        Desktop.getDesktop().browse(new URI("http://www.google.com"));
        txt.setText("http://www.google.com");
    }

    @FXML
    public void load() {
        if(first){
              engin.load("http://www.google.com");
              first=false;
        }else{
            engin.load("http://www."+ txt.getText());
        }
      
    }

    @FXML
    public void loadagin() {
        engin.reload();
    }

    @FXML
    public void zoomin() {
        zoomvalue += 0.25;
        webviwe.setZoom(zoomvalue);
    }

    @FXML
    public void zoomout() {
        zoomvalue -= 0.25;
        webviwe.setZoom(zoomvalue);
    }

    @FXML
    public void history() {
        webhistory = engin.getHistory();
        ObservableList<WebHistory.Entry> entries = webhistory.getEntries();

        for (WebHistory.Entry urls : entries) {
            System.out.println(urls.getUrl() + " " + urls.lastVisitedDateProperty());
        }
    }

    @FXML
    public void back() {
        webhistory = engin.getHistory();
        ObservableList<WebHistory.Entry> entries = webhistory.getEntries();
        webhistory.go(-1);
        txt.setText(entries.get(webhistory.getCurrentIndex()).getUrl());
    }

    @FXML
    public void forward() {
        webhistory = engin.getHistory();
        ObservableList<WebHistory.Entry> entries = webhistory.getEntries();
        webhistory.go(1);
        txt.setText(entries.get(webhistory.getCurrentIndex()).getUrl());

    }
}
