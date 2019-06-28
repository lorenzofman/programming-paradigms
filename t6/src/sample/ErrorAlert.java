package sample;

import javafx.scene.control.Alert;

public class ErrorAlert
{
    public static void DisplayError(String formattedError, Exception ex)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(formattedError);
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }

}
