package app;

import app.game.Game;
import app.game.tools.Params;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles window initialization and primary game setup
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */

public class Main extends Application {
    public static Stage screen;

    @Override
    public void start(Stage stage) throws IOException {
        screen = stage;

        screen.setTitle(Params.WINDOW_TITLE);
        screen.setScene(startMenu());
        screen.show();
    }

    public static Scene startMenu() throws IOException {
        Parent fxml = FXMLLoader.load(Main.class.getResource("menu/menu.fxml"));
        Scene scene = new Scene(fxml, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);

        return scene;
    }

    public static Scene startGame() {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);
        StackPane holder = new StackPane();

        holder.getChildren().add(canvas);
        holder.setStyle("-fx-background-color: black");

        root.getChildren().add(holder);

        // Setup Game object
        Game.getInstance().start();

        // Register User Input Handler
        scene.setOnKeyPressed  ((KeyEvent event) -> Game.getInstance().onInput(event.getCode(), true));
        scene.setOnKeyReleased ((KeyEvent event) -> Game.getInstance().onInput(event.getCode(), false));

        // Register Game Loop
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            long lastNanoTime = System.nanoTime();

            @Override
            public void handle(long currentNanoTime) {
                long deltaTime = currentNanoTime - lastNanoTime;

                Game.getInstance().update(currentNanoTime, deltaTime);
                gc.clearRect(0, 0, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);
                gc.setFill(Paint.valueOf("#FFFFFF"));
                gc.fillText("SCORE: " + Game.getInstance().getScore(), 10, 20);
                gc.fillText("LEVEL: " + 3, 120, 20);
                gc.fillText("LIVES: " + Game.getInstance().getLives(), 200, 20);
                gc.setFont(new Font("Arial Bold", 15));

                Game.getInstance().draw(gc);
                if (Game.getInstance().isGameOver()) {
                    stop();
                }

                lastNanoTime = currentNanoTime;
            }

        }.start();

        return scene;
    }

    public static Scene startSettings() throws IOException {
        Parent fxml = FXMLLoader.load(Main.class.getResource("settings/settings.fxml"));
        Scene scene = new Scene(fxml, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);

        return scene;
    }

    public static Scene startScore() throws IOException {
        Parent fxml = FXMLLoader.load(Main.class.getResource("scores/scores.fxml"));
        Scene scene = new Scene(fxml, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);

        return scene;
    }

    public static Scene startGameOver() throws IOException {
        Parent fxml = FXMLLoader.load(Main.class.getResource("gameover/gameover.fxml"));
        Scene scene = new Scene(fxml, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);

        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}
