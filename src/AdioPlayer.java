import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import sun.awt.SunToolkit;

public class AdioPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static final
    //String MEDIA_URL = "http://www.cs.armstrong.edu/lang/common/audio/anthem/anthem2.mp3";
    //String MEDIA_URL = "https:///media/js/freesound.js?v=2411";
   // String MEDIA_URL = "Drake_Keep_The_Family_Close_(Gurusvoice.Com).mp3";

    String MEDIA_URL = "http://cs.armstrong.edu/liang/common/sample.mp4";
    ;

    @Override
// Override the start method in the Application class
    public void
    start(Stage primaryStage) {
        Media media = new Media(MEDIA_URL);
        //Media media = new Media(new File(MEDIA_URL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        Button playButton = new Button("play");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals("play")) {
                mediaPlayer.play();
                playButton.setText("pause");
            } else {
                mediaPlayer.pause();
                playButton.setText("play");
            }
        });
        Button loopButton = new Button("loop");
        loopButton.setOnAction(e -> {
            if (loopButton.getText().equals("loop")) {
                mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
                loopButton.setText("exitloop");}
             else {
                mediaPlayer.stop();
                loopButton.setText("loop");
            }
        });
        Button stopButton = new Button("stop");
        stopButton.setOnAction(e -> {
            if (stopButton.getText().equals("stop")) {
                mediaPlayer.stop();}
        });
        HBox hBox = new HBox(10);
              hBox.setAlignment(Pos.CENTER);
              hBox.getChildren().addAll(playButton, loopButton,stopButton);

        BorderPane pane = new BorderPane();
              pane.setCenter(mediaView);
              pane.setBottom(hBox);

// Create a scene and place it in the stage
              Scene scene = new Scene(pane,500,500);
              primaryStage.setTitle("MediaDemo");
// Set the stage title
              primaryStage.setScene(scene);
// Place the scene in the stage
              primaryStage.show();
    }
}