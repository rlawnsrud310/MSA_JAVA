package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListController {

    @FXML
    private TableView<Board> boardTableView;

    @FXML
    private TableColumn<Board, Integer> colNo;

    @FXML
    private TableColumn<Board, String> colTitle;
    
    @FXML
    private TableColumn<Board, String> colWriter;
    
    @FXML
    private TableColumn<Board, String> colRegDate;

    @FXML
    private TableColumn<Board, Integer> colView;
    
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField keyWord;
    // 콤보박스 변경 시
    @FXML
    void comboChange(ActionEvent event) {
    }
    // 검색 버튼
    @FXML
    void search(ActionEvent event) {

    }

    List<Board> boardList = null;
    // 콤보박스 내용 작성
    ObservableList<String> list = FXCollections.observableArrayList("제목","작성자"); 
    // 게시글 목록 서비스
    private BoardService boardService = new BoardServiceImpl();
    
    @FXML
    public void initialize() {
    	// 콤보 박스 세팅
    	comboBox.setItems(list);
    	// 데이터 목록 조회
    	boardList = boardService.list();
    	// * TableColumn 에 Board 객체의 속성 매핑하기
    	colNo.setCellValueFactory( new PropertyValueFactory<>("No"));;
    	colTitle.setCellValueFactory( new PropertyValueFactory<>("Title"));;
    	colWriter.setCellValueFactory( new PropertyValueFactory<>("Writer"));;
    	colRegDate.setCellValueFactory( new PropertyValueFactory<>("RegDate"));;
    	colView.setCellValueFactory( new PropertyValueFactory<>("View"));;
    	// (코드 설명)
    	// * new PropertyValueFactory("게터이름")					: 값으로 들어갈 객체의 게터 이름을 지정
    	// ex) new PropertyValueFactory("Title") --> getTitle() 게터 멧드의 get 을 제외한 "Title"와 일치
    	// ** module-info.java 에 java.base 모듈 추가해야 사용가능		: 셀의 값을 지정하는 메소드
    	
    	// 테이블뷰에 데이터 추가하기
    	ObservableList<Board> list = FXCollections.observableArrayList(boardList);
    	boardTableView.setItems(list);
    	boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount()==2 && boardTableView.getSelectionModel().getSelectedItem() != null) {
					try {
						Main.setRoot("UI/Read");
					} catch (Exception e) {
						System.err.println("읽기 에러");
					}
					
				}
			}
		});
    }
    
    @FXML
    void toInsert(ActionEvent event) throws IOException {
    	Main.setRoot("UI/Insert");
    }

}
