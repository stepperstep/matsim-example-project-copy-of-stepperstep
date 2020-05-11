package org.matsim.project;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.PersonEntersVehicleEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.events.handler.PersonEntersVehicleEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    Map<Id<Person>, Double> departureTimeByPersonMap = new HashMap<>();
    @Override
    public void handleEvent(PersonDepartureEvent event) {
        System.out.println("Departure event; time " + event.getTime() + " -- linkId: " + event.getLinkId() + "personId: " + event.getPersonId());
        departureTimeByPersonMap.put(event.getPersonId(),event.getTime());
    }
    public void handleEvent(PersonArrivalEvent event) {
        System.out.println("Arrival event; time " + event.getTime() + " -- linkId: " + event.getLinkId() + "personId: " + event.getPersonId());
        System.out.println("Travel Time: "+(event.getTime() - departureTimeByPersonMap.get(event.getPersonId())));

    }


}
