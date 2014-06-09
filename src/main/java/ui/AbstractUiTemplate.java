package ui;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by admin on 2014. 6. 5..
 */
public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {

        showMenu();

        String inputedString  = getInputedString();

        execute(NumberUtils.toInt(inputedString));

    }

    abstract protected void showMenu();

    abstract protected int getMaxMenuNumber();

    abstract protected int getMinMenuNumber();

    abstract protected void execute(int number);



}
