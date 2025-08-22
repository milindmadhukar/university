import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewQuestion extends Application {

	@Override
	public void start(Stage stage) {
		// UI controls
		TextField urlField = new TextField("https://www.lonelyplanet.com");
		urlField.setPrefColumnCount(40);
		Button browseBtn = new Button("Browse");
		Label status = new Label();

		// WebView + engine
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();

		// Small helper to load the url from the field
		Runnable loadCurrent = () -> {
			String raw = urlField.getText().trim();
			if (raw.isEmpty()) {
				status.setText("Enter a URL");
				return;
			}
			// Add scheme if missing for convenience
			if (!raw.matches("(?i)^[a-z][a-z0-9+.-]*://.*")) {
				raw = "https://" + raw;
			}
			status.setText("Loading ...");
			engine.load(raw);
		};

		// Event handling: button click & Enter key in the field
		browseBtn.setOnAction(e -> loadCurrent.run());
		urlField.setOnAction(e -> loadCurrent.run());

		// Update status when load succeeds or fails
		engine.locationProperty().addListener((obs, o, n) -> status.setText(n));
		engine.setOnError(err -> status.setText("Error: " + err.getMessage()));

		// Layout
		HBox topBar = new HBox(6, new Label("URL:"), urlField, browseBtn);
		BorderPane root = new BorderPane();
		root.setTop(topBar);
		root.setCenter(webView);
		root.setBottom(status);

		stage.setTitle("Travel Info Kiosk (Demo)");
		stage.setScene(new Scene(root, 1000, 700));
		stage.show();

		// Load initial page
		loadCurrent.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
