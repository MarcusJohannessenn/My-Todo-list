package no.marcusjohannessen.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.marcusjohannessen.todolist.datamodel.TodoData;
import no.marcusjohannessen.todolist.datamodel.TodoItem;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // important to load the right FXML
        scene = new Scene(loadFXML("controller"), 900, 500);
        primaryStage.setTitle("To-do list");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    /**
     * Vi vil lagre dataene når vi lukker appen
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        try{
            TodoData.getInstance().storeTodoItems();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void init() throws Exception {
        try{
            TodoData.getInstance().loadTodoItems();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}