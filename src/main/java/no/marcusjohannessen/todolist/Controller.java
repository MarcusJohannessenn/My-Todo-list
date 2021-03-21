package no.marcusjohannessen.todolist;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import no.marcusjohannessen.todolist.datamodel.TodoItem;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView todoListView;



    public void initialize(){
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a gift", LocalDate.of(2021, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Homework", "Mathematics", LocalDate.of(2021, Month.APRIL, 14));
        TodoItem item3 = new TodoItem("Doctor", "Foot injury", LocalDate.of(2021, Month.JUNE, 3));
        TodoItem item4 = new TodoItem("Go to shop", "Buy a cake", LocalDate.of(2021, Month.APRIL, 12));
        TodoItem item5 = new TodoItem("Do something", "Go for a run", LocalDate.of(2021, Month.APRIL, 4));


        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);


        todoListView.getItems().setAll(todoItems);
        //todoListView.getSelectionModel().getSelectionMode(SelectionMode.SINGLE);
    }


}
