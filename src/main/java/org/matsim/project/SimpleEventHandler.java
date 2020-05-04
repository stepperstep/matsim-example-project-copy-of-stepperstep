package org.matsim.project;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimpleEventHandler implements PersonDepartureEventHandler {
    @Override
    public void handleEvent(PersonDepartureEvent event) {
        System.out.println("Departure event; time " + event.getTime() + " -- linkId: " + event.getLinkId() + "personId: " + event.getPersonId());
    }
    public void handleEvent(PersonArrivalEvent event) {
        System.out.println("Departure event; time " + event.getTime() + " -- linkId: " + event.getLinkId() + "personId: " + event.getPersonId());
    }
}
