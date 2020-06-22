package org.matsim.project;

import ch.sbb.matsim.routing.pt.raptor.SwissRailRaptorModule;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.pt.transitSchedule.TransitLineImpl;
import org.matsim.pt.transitSchedule.api.*;

import java.util.ArrayList;
import java.util.List;

public class TransitScheduleValidator {

    public static void main(String[] args) {

        Config config = ConfigUtils.loadConfig("scenarios/pt-tutorial/0.config.xml");
        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setLastIteration(1);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controler controler = new Controler(scenario);
        controler.addOverridingModule( new SwissRailRaptorModule());
        controler.run();

        TransitScheduleReader reader = new TransitScheduleReader(scenario);
        reader.readFile("scenarios/pt-tutorial/transitschedule.xml");

        for ( Id<TransitLine> transitLine : scenario.getTransitSchedule().getTransitLines().keySet()){
            if (transitLine.equals("Blue Line")){


            }
        }
        TransitLine transitLine = scenario.getTransitSchedule().getTransitLines().get("Blue Line");
        TransitRoute transitRoute = transitLine.getRoutes().get("1to3");
        List<Departure> departures = new ArrayList<>();






    }
}
