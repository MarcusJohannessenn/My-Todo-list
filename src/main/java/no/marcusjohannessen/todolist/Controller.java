package no.marcusjohannessen.todolist;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import no.marcusjohannessen.todolist.datamodel.TodoItem;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;



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

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadLineLabel.setText(df.format(item.getDeadLine()));
                }
            }
        });


        todoListView.getItems().setAll(todoItems);
        //todoListView.getSelectionModel().getSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadLineLabel.setText(item.getDeadLine().toString());

        //System.out.println("The selected item is " + item);
       /*
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadLine().toString());
        itemDetailsTextArea.setText(sb.toString());

        */
    }
}
