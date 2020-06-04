package org.matsim.project;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkEnterEvent;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkEnterEventHandler;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LinkEventHandler implements LinkEnterEventHandler, LinkLeaveEventHandler {

    private final BufferedWriter bufferedWriter;

    public LinkEventHandler(String outputFile){
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (IOException ee) {
            throw new RuntimeException(ee);
        }
    }

    private double[] volumeLink6 = new double[24];

    private int getSlot(double time) {
        return (int) time/3600;
    }

    public void handleEvent(LinkEnterEvent event) {
        if (event.getLinkId().equals(Id.createLinkId("6"))) {
            System.out.println("WICHTIG");
            int slot = getSlot(event.getTime());
            this.volumeLink6[slot]++;
        }
    }

    public void printResult() {
        try {
            bufferedWriter.write("Hour \t Volume");
            for (int i = 0; i < 24; i++) {
                double volume = this.volumeLink6[i];
                bufferedWriter.write(i + "\t" + volume);
                bufferedWriter.newLine();
                //System.out.println("Volume on link 6 from " + i + " to "+ (i+1) + " o'clock: " + volume);
            }
            bufferedWriter.close();
        }
        catch(IOException ee) {
                throw new RuntimeException(ee);
            }
    }

    public void handleEvent(LinkLeaveEvent event) {
        System.out.println("LinkLeaveEvent: " +event.getLinkId());
    }
}
