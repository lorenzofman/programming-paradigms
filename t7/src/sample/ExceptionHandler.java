package sample;

import javafx.scene.control.Alert;

import javax.naming.LimitExceededException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class ExceptionHandler {
    public static void displayException(Exception exception)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText(exception.getMessage());
        try
        {
            throw exception;
        }
        catch (MalformedURLException e) {
            alert.setContentText("Invalid URL, please check your input");
        }
        catch (FileNotFoundException e)
        {
            alert.setContentText("File not found");
        }
        catch (LimitExceededException e)
        {
            alert.setContentText("5000 commits Github limit exceeed. Please wait one hour");
        }
        catch (Exception e)
        {
            alert.setContentText("There is something strange\nWe found an unexpected runtime error");
        }

        alert.showAndWait();
    }
}
