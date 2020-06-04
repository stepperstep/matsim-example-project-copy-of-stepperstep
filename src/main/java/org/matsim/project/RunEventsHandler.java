package org.matsim.project;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;

public class RunEventsHandler {

    public static void main(String[] args) {

        String inputFile = "output1/output_events.xml.gz";
        String outputFile = "output1/link6volumes.txt";

        EventsManager eventsManager = EventsUtils.createEventsManager();

        LinkEventHandler linkEventHandler = new LinkEventHandler(outputFile);
        eventsManager.addHandler(linkEventHandler);
        
        MatsimEventsReader eventsReader = new MatsimEventsReader(eventsManager); //reads the file and gives informations to the Eventhandler
        eventsReader.readFile(inputFile);



    linkEventHandler.printResult();
    }
}
