package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 2014. 5. 28..
 */
public abstract class AbstractUi {

    protected String getInputedString() {

        BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            return input.readLine();
        } catch(IOException e) {
            throw new IORuntimeException("No input", e);
        }

        /*
        Console console;
        String input = null;

        try {
            console = System.console();


            if(console != null) {

                input = console.readLine();
            }
        } catch(Exception ex) {

            ex.printStackTrace();
        }

        return input;
        */
    }

    abstract public void show();
}
