package application.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController {

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
    private Label outView;

    @FXML
    private TextField outWriter;

    int no;
    
    BoardService boardService = new BoardServiceImpl();
    Board board = new Board();
    
    // 뒤로가기 버튼
    @FXML
    void toRead(ActionEvent event) throws IOException {
		// ReadController 가져오기
		FXMLLoader ReadFXML = new FXMLLoader(getClass().getResource("/application/UI/Read.fxml"));
		Parent readRoot = ReadFXML.load();
		ReadController read = ReadFXML.getController();
		//데이터를 Read컨트롤러로 전달
		read.passDataTitle(board.getTitle());
		read.passDataWriter(board.getWriter());
		read.passDataContent(board.getContent());
		read.passDataNo(no);
		read.passDataReg(board.getRegDate());
		read.passDataUpd(board.getUpdDate());
		Main.setRoot(readRoot);
    }

    // 수정 기능 구현
    @FXML
    void update(ActionEvent event) throws IOException {
    	board.setTitle(outTitle.getText());
    	board.setWriter(outWriter.getText());
    	board.setContent(outContent.getText());
    	boardService.update(board);
    	Main.setRoot("UI/List");
    }

    // UI 출력
    public void passData(int no) {
    	this.no= no;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	board = boardService.select(no);
    	outTitle.setText(board.getTitle());
    	outWriter.setText(board.getWriter());
    	outContent.setText(board.getContent());
    	outNo.setText("No. "+board.getNo());
        outReg.setText(format.format(board.getRegDate()));
        outUpd.setText(format.format(board.getUpdDate()));
    	outView.setText("조회수 : " + board.getView());
    }
}
