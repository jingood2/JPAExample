package ui;

import dao.TicketDao;
import dao.UserDao;
import models.TicketEntity;
import models.UserEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by admin on 2014. 6. 5..
 */
public class SelectUserUi extends AbstractUi {

    private UserDao userDao;
    private TicketDao ticketDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public void show() {

        showHeader();

        showMenu("User Name");

        String userName = getInputedString();

        UserEntity user = this.userDao.getUser(userName);

        showUser(user);

        System.out.printf("userId:%d%n",user.getUserId());

        List<TicketEntity> ticketList = this.ticketDao.getBookedTicketList(user.getUserId());

        if(ticketList == null) {
            System.out.println("No list");
            System.exit(0);
        }
        else {
            showBookedTicketList(ticketList);
        }

    }

    protected void showBookedTicketList(List<TicketEntity> ticketList) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(("ID EventName EventDate Price BookingDate"));

        for(TicketEntity ticket : ticketList) {

            System.out.printf("%s %s %s %s %s%n", ticket.getTicketId(),
                    ticket.getEvent().getName(),dateFormat.format(ticket.getEvent().getDate()),
                    ticket.getRank().getPrice(),dateFormat.format(ticket.getReservation().getReservedTs()));
        }
    }

    protected void showUser(UserEntity user) {

        System.out.println("........................");
        System.out.println("[Ticket Reservation][lists of confirmed ticket]");
        System.out.println("ID Name");
        System.out.printf("%s %s%n", user.getUserId(), user.getName());

    }

    protected void showHeader() {

        System.out.println("........................");
        System.out.println("[Ticket Reservation][lists of confirmed ticket]");
        System.out.println("");

    }

    protected void showMenu(String wanted) {
        System.out.printf("After input %s, Push the Enter! %n", wanted);
        System.out.println("return to main menu");
    }
}
