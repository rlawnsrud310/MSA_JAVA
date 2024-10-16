module JavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.gluonhq.attach.util;
	requires com.gluonhq.charm.glisten;
	
	opens application to javafx.graphics, javafx.fxml;
}
