package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.PlanCalcScoreConfigGroup;
import org.matsim.core.config.groups.PlansCalcRouteConfigGroup;
import org.matsim.core.config.groups.StrategyConfigGroup;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.replanning.strategies.DefaultPlanStrategiesModule;
import org.matsim.core.scenario.ScenarioUtils;

public class RunMultiModalExample {
    public static void main(String[] args) {

        Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");

        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setLastIteration(3);

        StrategyConfigGroup.StrategySettings stratSets = new StrategyConfigGroup.StrategySettings();
        stratSets.setWeight(0.1);
        stratSets.setStrategyName(DefaultPlanStrategiesModule.DefaultStrategy.ChangeSingleTripMode);
        config.strategy().addStrategySettings(stratSets);

        config.changeMode().setModes(new String[] {"pedelec"});

        PlansCalcRouteConfigGroup.ModeRoutingParams pars = new PlansCalcRouteConfigGroup.ModeRoutingParams("pedelec");
        pars.setMode("pedelec");
        pars.setTeleportedModeSpeed();
        config.plansCalcRoute().addModeRoutingParams(pars);

        PlanCalcScoreConfigGroup.ModeParams pars2 = new PlanCalcScoreConfigGroup.ModeParams("pedelec");
        config.plansCalcRoute().addModeRoutingParams(pars2);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controler controler = new Controler(scenario);

        controler.run();

    }
}
