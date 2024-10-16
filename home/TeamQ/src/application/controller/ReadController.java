package application.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import application.Main;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ReadController {

	@FXML
    private TextArea outContent;

    @FXML
    private TextField outNo;

    @FXML
    private Label outReg;

    @FXML
    private TextField outTitle;

    @FXML
    private Label outUpd;

    @FXML
    private TextField outWriter;
    
    @FXML
    private Label outView;
    
    int no;
    BoardService boardService = new BoardServiceImpl();
    
    //리스트 클릭시 화면전환
    @FXML
    void toList(ActionEvent event) throws IOException{
    	Main.setRoot("UI/List");
    }
    @FXML
    void delete(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("삭제");
    	alert.setHeaderText("정말 삭제하시겠습니까?");
    	alert.setContentText("확인 버튼을 누르면 삭제됩니다.");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		boardService.delete(no);
    		Main.setRoot("UI/List");
    	}
    }
    @FXML
    void toUpdate(ActionEvent event) throws IOException {
		// ReadController 가져오기
		FXMLLoader updateFxml = new FXMLLoader(getClass().getResource("/application/UI/Update.fxml"));
		Parent updateRoot = updateFxml.load();
		UpdateController update = updateFxml.getController();
		//데이터를 Read컨트롤러로 전달
		update.passData(no);
		Main.setRoot(updateRoot);
    }
    
    
    //출력
    public void passDataTitle(String data) {
		outTitle.setText(data);
	}
    public void passDataWriter(String data) {
		outWriter.setText(data);
	}
    public void passDataContent(String data) {
		outContent.setText(data);
	}
    public void passDataNo(int data) {
    	no = data;
		outNo.setText("No. "+data);
	}
    public void passDataReg(Date reg) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(reg);
    	outReg.setText(str);
    }
	public void passDataUpd(Date upd) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(upd);
    	outUpd.setText(str);
	}
	public void passDateView(int view) {
		outView.setText("조회수 : " + view);
	}
}
