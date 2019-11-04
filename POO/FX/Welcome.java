import java.net.PasswordAuthentication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Welcome extends Application {
    private TextField userTextField;
    private PasswordField pwBox;
    private Text actiontarget;
    private int erros;

    public Welcome(){
        erros = 0;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Insira seu login!"); //palco (principal)


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        // grid.setGridLinesVisible(true);

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        Button btnC = new Button("Cancel");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        hbBtn.getChildren().add(btnC);
        grid.add(hbBtn, 1, 4);

        // Button btnC = new Button("Cancel");
        // HBox hbBtnC = new HBox(10);
        // hbBtnC.setAlignment(Pos.BOTTOM_RIGHT);
        // hbBtnC.getChildren().add(btnC);
        // grid.add(hbBtnC, 1, 4);

        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");

        btn.setOnAction(e -> this.trataBotaoCancel(e));
        btnC.setOnAction(e -> this.trataBotaoCancel(e));

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void trataBotaoCancel(ActionEvent e){
        userTextField.setText("");
        pwBox.setText("");
    }
 
    public void trataBotaoSignIn(ActionEvent e) {
        actiontarget.setFill(Color.FIREBRICK);
        
        Alert msgBox = new Alert(AlertType.INFORMATION);
        if(pwBox.getText().equals("senha")){
            msgBox.setHeaderText("Botao acionado");
            String str = userTextField.getText() + "\n"+
                         pwBox.getText();
            msgBox.setContentText(str);
            msgBox.showAndWait();
            actiontarget.setText(" ");
            actiontarget.setText("Sign in button pressed");
        }
        else{
            if(erros >= 3){
                System.exit(0);
            }
            else{
                erros++;
                msgBox.setHeaderText("BAH!");
                msgBox.showAndWait();
                actiontarget.setText("");
                actiontarget.setText("Wrong Password!");
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
