package application.controller;

import java.io.IOException;
import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class MainController {

    @FXML
    private Button btnList;

    // 종료 버튼
    @FXML
    void exit(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("종료");
    	alert.setHeaderText("정말 종료하시겠습니까?");
    	alert.setContentText("확인 버튼을 누르면 종료됩니다.");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		System.exit(0);
    	}
    }

    /**
     * 게시글 목록으로 이동
     * @param event
     */
    @FXML
    void toList(ActionEvent event)throws IOException {
    	Main.setRoot("UI/List");
    }

}
