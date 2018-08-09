package nl.hva.jeecourse.module00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SimpleWebClient extends Application {

    private static final DateFormat df = DateFormat.getDateTimeInstance(
            DateFormat.FULL, DateFormat.FULL);

    public void start(Stage stage) throws Exception {
        stage.setTitle("Simple Web Client");

        RootView root = new RootView();
        Scene scene = new Scene(root, 1200, 800, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class RootView extends javafx.scene.layout.BorderPane {

        private ComboBox<String> method;
        private ComboBox<String> examples;
        private TextField url;
        private TextArea headers;
        private TextArea body;

        private TextField responseLine;
        private TextArea responseHeaders;
        private TextArea responseBody;

        private TextArea log;
        private Button btSend;

        public RootView() {
            setPadding(new Insets(10, 10, 10, 10));
            initializeComponents();
            configureLeftPanel();
            configureRightPanel();
            configureBottomPanel();
        }

        private void initializeComponents() {

            method = new ComboBox<String>();
            method.setItems(FXCollections.observableList(Arrays.asList("GET", "POST", "PUT", "DELETE", "TRACE", "OPTIONS", "CONNECT")));
            method.getSelectionModel().select(0);

            examples = new ComboBox<String>();
            examples.setItems(FXCollections.observableList(Arrays.asList("Example 01 - URL with port and path",
                    "Example 02 - URL with port, path and query",
                    "Example 03 - GET example",
                    "Example 04 - POST example",
                    "Example 05 - HTTP status code - Success",
                    "Example 06 - HTTP status code - Client Error",
                    "Example 07 - HTTP status code - Server Error",
                    "Example 08 - HTTP status code - Redirection",
                    "Example 09 - Content-type - HTML",
                    "Example 10 - Content-type - JSON",
                    "Example 11 - Content-type - Binary Image")));
            examples.setOnAction(evt -> {

                String selected = examples.getSelectionModel().getSelectedItem();
                selected = selected.substring(8, 10);

                switch (selected) {
                    case "01":
                        url.setText("http://localhost:8080/JEECourse/module02/example02");
                        method.getSelectionModel().select(0);
                        break;
                    case "02":
                        url.setText("http://localhost:8080/JEECourse/module02/example02?course=JEE&month=august");
                        method.getSelectionModel().select(0);
                        break;
                    case "03":
                        url.setText("http://localhost:8080/JEECourse/module02/example02?course=JEE&month=august");
                        method.getSelectionModel().select(0);
                        break;
                    case "04":
                        url.setText("http://localhost:8080/JEECourse/module02/example02");
                        body.setText("course=JEE&month=august");
                        method.getSelectionModel().select(1);
                        break;
                    case "05":
                        url.setText("http://localhost:8080/JEECourse/module02/example02");
                        body.setText("course=JEE&month=mars");
                        method.getSelectionModel().select(1);
                        break;
                    case "06":
                        url.setText("http://localhost:8080/JEECourse/module99/example100");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;
                    case "07":
                        url.setText("http://localhost:8080/JEECourse/module00/example07.jsp");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;
                    case "08":
                        url.setText("http://localhost:8080/JEECourse/module03/example08?query=memes&engine=1");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;
                    case "09":
                        url.setText("http://localhost:8080/JEECourse/module03/example01");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;
                    case "10":
                        url.setText("http://localhost:8080/JEECourse/module03/example02");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;
                    case "11":
                        url.setText("http://localhost:8080/JEECourse/images/paypal.png");
                        body.setText("");
                        method.getSelectionModel().select(0);
                        break;

                    default:
                        break;
                }

            });


            url = new TextField(
                    "http://localhost:8080/JEECourse/module02/example02?course=JEE&month=mars");
            url.setPromptText("url");
            headers = new TextArea(
                    "User-Agent: WebClient\n"
                            + "Accept-Language: en-us,en;q=0.5\n"
                            + "Content-Type: application/x-www-form-urlencoded\n");
            headers.setPromptText("headers");
            body = new TextArea();
            body.setPromptText("body");
            responseLine = new TextField();
            responseLine.setPromptText("response line");
            responseHeaders = new TextArea();
            responseHeaders.setPromptText("response headers");
            responseBody = new TextArea();
            responseBody.setPromptText("response body");
            responseBody.setWrapText(true);
            log = new TextArea("");

            btSend = new Button("send");
            btSend.setOnAction(evt -> {
                Platform.runLater(() -> executeRequest());
            });

        }

        private void executeRequest() {

            clearOutput();
            clearErrors();

            URL u = null;
            try {
                u = new URL(url.getText());
            } catch (MalformedURLException e) {
                log("Error generating URL: " + e.getMessage());
                return;
            }

            log("Protocol: " + u.getProtocol());
            log("Host: " + u.getHost());
            log("Port: "
                    + (u.getPort() == -1 ? u.getDefaultPort() : u.getPort()));
            log("Path: " + u.getPath());
            log("Query: " + u.getQuery());
            log("Anchor: " + u.getRef());

            try {
                Socket s = new Socket(u.getHost(),
                        u.getPort() == -1 ? u.getDefaultPort() : u.getPort());

                PrintWriter writer = new PrintWriter(s.getOutputStream(), false);

                String requestLine = method.getSelectionModel()
                        .getSelectedItem()
                        + " "
                        + u.getPath()
                        + (u.getQuery() != null ? "?" + u.getQuery() : "")
                        + " HTTP/1.0";
                log("Connecting to host");
                log("Request Line: " + requestLine);

                writer.print(requestLine + "\r\n");

                BufferedReader bre = new BufferedReader(new StringReader(
                        headers.getText()));
                for (; ; ) {
                    String line = bre.readLine();
                    if (line == null)
                        break;
                    log("Header: " + line);
                    writer.print(line + "\r\n");
                }

                if (body.getText().trim().length() > 0) {
                    log("Header: " + "Content-Length: "
                            + body.getText().trim().length());
                    writer.print("Content-Length: "
                            + body.getText().trim().length() + "\r\n");
                }

                writer.print("\r\n");

                if (!body.getText().trim().equals("")) {
                    writer.print(body.getText().trim() + "\r\n");
                }

                writer.flush();

                InputStream is = s.getInputStream();

                int state = 0;
                // reading the textual part
                for (; ; ) {
                    String linha = readHTTPLine(is);
                    if (linha.equals(""))
                        break;
                    log("received line: " + linha);
                    if (state == 0) {
                        responseLine.setText(linha);
                        state = 1;
                        continue;
                    }
                    if (state == 1) {
                        responseHeaders.appendText(linha + "\n");
                        continue;
                    }
                }

                // reading the content
                byte[] buffer = new byte[1024 * 1024];

                int qtd = 0;

                while ((qtd = is.read(buffer)) != -1) {
                    if (qtd == buffer.length) {
                        String x = new String(buffer);
                        responseBody.appendText(x);
                        //log(x);
                    } else {
                        byte[] buffer2 = Arrays.copyOfRange(buffer, 0, qtd);
                        String x = new String(buffer2);
                        responseBody.appendText(x);
                        //log(x);
                    }
                }

                writer.close();
                bre.close();
                s.close();
            } catch (IOException e) {
                url.setStyle("-fx-border-color: red ;");
                url.setTooltip(new Tooltip("I/O Error: " + e.toString()));
                log("I/O Error: " + e.toString());
            }
        }

        private void clearOutput() {
            responseLine.setText("");
            responseHeaders.clear();
            responseBody.clear();
        }

        private void clearErrors() {
            url.setStyle("-fx-border-color: black ;");
            url.setTooltip(null);
        }

        private void configureLeftPanel() {
            VBox box = new VBox();
            box.setStyle("-fx-background-color: black;");
            box.setPadding(new Insets(10));
            box.setSpacing(10);

            FlowPane urlAndExamplesBox = new FlowPane();
            urlAndExamplesBox.setPadding(new Insets(10));
            urlAndExamplesBox.setHgap(10);
            urlAndExamplesBox.getChildren().addAll(method, examples);

            box.getChildren().addAll(urlAndExamplesBox, url, headers, body, btSend);
            setLeft(box);
        }

        private void configureRightPanel() {
            VBox box = new VBox();
            box.setStyle("-fx-background-color: black;");
            box.setPadding(new Insets(10));
            box.setSpacing(10);
            box.getChildren().addAll(responseLine, responseHeaders,
                    responseBody);
            setRight(box);
        }

        private void configureBottomPanel() {
            BorderPane box = new BorderPane();
            box.setPadding(new Insets(10));
            box.setTop(new Label("Console Log"));
            box.setCenter(log);
            setBottom(box);
        }

        private void log(String text) {
            log.appendText(df.format(new Date()) + " - " + text + "\n");
        }

    }

    public static String readHTTPLine(InputStream is) throws IOException {
        byte carac;
        StringBuffer buf = new StringBuffer(128);
        for (; ; ) {
            carac = (byte) is.read();
            // newline
            if (carac == -1 || carac == '\n')
                break;
            if (carac == '\r')
                continue;
            try {
                buf.append(Character.toChars(carac));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return buf.toString();
    }

}
