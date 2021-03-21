module no.marcusjohannessen.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.marcusjohannessen.todolist to javafx.fxml;
    exports no.marcusjohannessen.todolist;
}