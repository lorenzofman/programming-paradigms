package sample;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class CallbacksController {
    private InterfaceController interfaceController;
    private ArrayList<Commit> commits = new ArrayList<>();
    public CallbacksController(InterfaceController controller)
    {
        this.interfaceController = controller;
    }

    public void onOpen() throws IOException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(interfaceController.getStage());
        if(file == null)
        {
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            Commit cInfo = new Commit(line);
            commits.add(cInfo);
            interfaceController.addLabelToTable(cInfo);
            line = reader.readLine();
        }
    }

    public void onExit()
    {
        interfaceController.getStage().close();
    }

    public void onCommitAnalyze() {
        for(Commit commit : commits)
        {
            if(commit.getFetching() == false){
                GitRequester requester = new GitRequester(commit);
                Thread thread = new Thread(requester);
                thread.start();
            }
        }
    }



    public void onAbout()
    {
        interfaceController.showInfoDialog("About","Git analyzer", "Lorenzo SK\n2019");
    }
}
