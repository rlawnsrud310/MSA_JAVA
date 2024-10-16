package application.controller;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML
    private TextArea contentBox;

    @FXML
    private TextField titleBox;

    @FXML
    private TextField writerBox;

    @FXML
    void toList(ActionEvent event) throws Exception {
        Main.setRoot("UI/List");
    }

    @FXML
    void insert(ActionEvent event) throws Exception {
        Board board = new Board();
        board.setTitle(titleBox.getText());
        board.setWriter(writerBox.getText());
        board.setContent(contentBox.getText());
        BoardService service = new BoardServiceImpl();
        service.insert(board);
        Main.setRoot("UI/List");
        
    }
}
