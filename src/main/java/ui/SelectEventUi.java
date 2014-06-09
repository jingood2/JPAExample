package ui;

import dao.EventDao;
import models.EventEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2014. 5. 28..
 */
public class SelectEventUi extends AbstractUi {


    private static final String DATE_FORMAT_MESSAGE = "Date format YYYYMMDD";

    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public void show() {

        // show header
        showHeader();

        // show menu
        showMenu("search start day:");

        Date start = getDate();
        if(start == null) {
            return ;
        }

        showMenu("search end day:");

        Date end = getDate();
        if(end == null) {
            return ;
        }

        List<EventEntity> eventList = this.eventDao.getEventList(start,end);
        showEventList(eventList);

    }

    protected void showEventList(List<EventEntity> eventList) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        for(EventEntity event: eventList) {

            System.out.printf("%s %s %s%n", event.getEventId(), event.getName(), dateFormat.format(event.getDate()));
        }

    }

    protected Date getDate() {

        String dateString = getInputedString();

        if(dateString.length() != 8) {

            System.out.println(DATE_FORMAT_MESSAGE);
            return getDate();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date;
        try {

            date = dateFormat.parse(dateString);
        } catch (ParseException e) {

            System.out.println(DATE_FORMAT_MESSAGE);
            return getDate();
        }

        return date;

    }

    protected void showHeader() {

        System.out.println("-----------------------------------");
        System.out.println("[ticket reservation][Browsing Event]");
        System.out.println("");
    }

    protected void showMenu(String wanted) {

        System.out.printf("After Input %s , then input Enter", wanted);
        System.out.println(DATE_FORMAT_MESSAGE);
    }
}
