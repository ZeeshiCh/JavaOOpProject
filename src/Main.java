import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    static int counter=0;
    static int circleLen = 50;

    public static void main(String[] args) {
        launch();

        System.out.println("System");
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<Circle> circles = new ArrayList<>();

        //circles.add(new Circle(50,50,30, Color.GREEN));


        Random random = new Random();
        for (int i = 0; i < circleLen; i++) {
            circles.add(new Circle(45,45,random.nextDouble(5,40),
                    Color.rgb(random.nextInt(0,255),random.nextInt(0,255),random.nextInt(0,255))));
        }

        GridPane gridPane = new GridPane();
        Group group = new Group();
       gridPane.setVgap(5);
       gridPane.setHgap(5);
       // gridPane.setAlignment(Pos.CENTER);

        Text text =new Text();
        text.setFill(Color.RED);


        Scene scene = new Scene(gridPane,800,600);

        TextField textfield = new TextField();
        textfield.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText("");
                Integer input = Integer.parseInt(textfield.getText());
                if(input<=50) {
                    circles.get(0).setRadius(circles.get(input).getRadius());
                    circles.get(0).setFill(circles.get(input).getFill());
                }
                else{
                    text.setText("Wrong Input");
                  gridPane.add(text,35,92);
                }
            }
        });
        gridPane.add(textfield,35,90);

        Button b1 = new Button("Next");
        gridPane.add(b1,36,90);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText("");
                //gridPane.add(circles.get(0),50,50);
                circles.get(0).setRadius(circles.get(counter).getRadius());
                circles.get(0).setFill(circles.get(counter).getFill());

                if(counter<circleLen)
                    counter++;
                else
                    counter=0;

            }
        });
        gridPane.add(circles.get(0),50,50);


        stage.setScene(scene);
        stage.show();



    }

}