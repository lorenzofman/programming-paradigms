package sample;

import javafx.stage.FileChooser;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CallbacksController implements RequestProcessable {
    private InterfaceController controller;
    private File file;
    public CallbacksController(InterfaceController controller)
    {
        this.controller = controller;
    }

    public void onOpen()
    {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(controller.getStage());
    }

    public void onExit()
    {
        controller.getStage().close();
    }

    public void onCommitAnalyze() throws IOException {
        if(file == null)
        {
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            new GitRequester(line,this).run();
            line = reader.readLine();
        }
    }



    public void onAbout()
    {
        controller.showInfoDialog("About","Git analyzer", "Lorenzo SK\n2019");
    }

    @Override
    public void requestDone(int commitNumber, int commitsLength) {

    }
}
