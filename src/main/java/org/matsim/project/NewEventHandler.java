package org.matsim.project;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkEnterEvent;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkEnterEventHandler;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;

import java.util.HashMap;
import java.util.Map;

public class NewEventHandler implements LinkEnterEventHandler, LinkLeaveEventHandler {

    Map<Integer, Integer> enterEventMap = new HashMap<>();
    int enteredLink6 = 0;


    public void handleEvent(LinkEnterEvent event) {
        int eventtime = (int) event.getTime()/3600;
        if (event.getLinkId().equals(Id.createLinkId(6))) {
            enteredLink6 =+ 1;

        }
        System.out.println("LinkEnterEvent: " +event.getLinkId() + "TIME: " + eventtime);
        System.out.println("Counter: " + enteredLink6);
    }

    public void handleEvent(LinkLeaveEvent event) {
        System.out.println("LinkLeaveEvent: " +event.getLinkId());
    }
}
