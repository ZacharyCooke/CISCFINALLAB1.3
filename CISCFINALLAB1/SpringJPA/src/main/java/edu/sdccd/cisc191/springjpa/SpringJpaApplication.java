package edu.sdccd.cisc191.springjpa;

import edu.sdccd.cisc191.springjpa.exercises.Exercise;
import edu.sdccd.cisc191.springjpa.exercises.Option;
import edu.sdccd.cisc191.springjpa.services.Fitness;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication extends Application {
    public ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(SpringJpaApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: fix the spring context below to match what it needs to be.  ei. 13:07 in lab video. VehicleService vehicleService = springContext.getBean(VehicleService.class)
        Fitness fitness = springContext.getBean(Fitness.class);
        primaryStage.setTitle("Fitness");
        VBox root = new VBox();

        for(Exercise exercise : fitness.findAll() ) {
            Button btn = new Button();
            btn.setText(exercise.getDateOfWorkout());
            btn.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exercise");
                alert.setHeaderText("Options");
                alert.setContentText(exercise.getOptionsAsString());
                alert.showAndWait();
            });
            root.getChildren().add(btn);
        }

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(SpringJpaApplication.class);

        Fitness fitness = springContext.getBean(Fitness.class);
        Option lunges = new Option("lunges");
        fitness.save(lunges);
        Option squats = new Option("squats");
        fitness.save(squats);
        Option jacks = new Option("jacks");
        fitness.save(jacks);
        Option plank = new Option("plank");
        fitness.save(plank);
        Option bench = new Option("bench");
        fitness.save(bench);

        List<Option> options = new ArrayList<>();
        options.add(lunges);
        options.add(squats);
        options.add(jacks);
        options.add(plank);
        options.add(bench);

        Exercise dateOfWorkout = new Exercise("Date", 1, 1, 1, 1, 1, 1, 1, 1, 1, options);
        fitness.save(dateOfWorkout);

        for (Exercise exercise : fitness.findAll()) {
            System.out.println(exercise.toString());
        }
    }

    public Server inMemoryDBServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092"  );
    };
}
