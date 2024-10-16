module Sample {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
