package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2014. 6. 5..
 */
public class MenuUi extends AbstractUiTemplate  {

    private SelectEventUi selectEventUi;
    private SelectUserUi selectUserUi;

    public void setSelectEventUi(SelectEventUi selectEventUi) {
        this.selectEventUi = selectEventUi;
    }

    public void setSelectUserUi(SelectUserUi selectUserUi) {
        this.selectUserUi = selectUserUi;
    }

    @Override
    protected void execute(int number) {

        switch (number) {

            case 1:
                System.out.println("Exit");
                System.exit(0);
            case 2:
                this.selectEventUi.show();
                break;
            case 3:
                this.selectUserUi.show();
                break;
        }
    }

    @Override
    protected void showMenu() {

        System.out.println("......................");
        System.out.println("[Ticket Booking][Menu]");
        System.out.println("");
        System.out.println("1.Exit");
        System.out.println("2.Event Browsing");
        System.out.println("3.Booking Confirmed Ticket List");
        System.out.println("");
        System.out.println("Push Enter Key ");
    }

    @Override
    protected int getMaxMenuNumber() {
        return 3;
    }

    @Override
    protected int getMinMenuNumber() {
        return 1;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

        MenuUi menuUi = context.getBean(MenuUi.class);

        while(true)
            menuUi.show();
    }

}
