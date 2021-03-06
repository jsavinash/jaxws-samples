package de.uniba.dsg.jaxws;

import de.uniba.dsg.jaxws.HistoryService;
import de.uniba.dsg.jaxws.History;
import de.uniba.dsg.jaxws.Chancellor;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.util.List;

public class DemoWSClient {
    public static void main(String[] args) throws DatatypeConfigurationException, IOException {
        // Parameters
        GregorianCalendar start = new GregorianCalendar(1949, 0, 1);
        GregorianCalendar end = new GregorianCalendar(2014, 0, 1);
        XMLGregorianCalendar from = DatatypeFactory.newInstance().newXMLGregorianCalendar(start);
        XMLGregorianCalendar to = DatatypeFactory.newInstance().newXMLGregorianCalendar(end);

        History historyService = new HistoryService().getHistoryPort();
        List<Chancellor> chancellors = historyService.getChancellors(from , to);

        System.out.println("Accessing Web service...");
        System.out.println("Getting chancellors from " + from.getYear() + " to " + to.getYear());
        System.out.println();

        for(Chancellor c : chancellors) {
            System.out.println("Name: " + c.getName());
            System.out.println("Party: " + c.getParty());
            System.out.println("Tenure: " + c.getFrom().getMonth() + "/" + c.getFrom().getYear() + "-" + c.getTo().getMonth() + "/" + c.getTo().getYear());
            System.out.println();
        }
    }
}