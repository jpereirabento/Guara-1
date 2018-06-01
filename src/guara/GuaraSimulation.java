package guara;

import us.ihmc.simulationconstructionset.SimulationConstructionSet;
import us.ihmc.simulationconstructionset.util.simulationRunner.BlockingSimulationRunner.SimulationExceededMaximumTimeException;
import us.ihmc.tools.thread.ThreadTools;

public class GuaraSimulation {
	SimulationConstructionSet sim;
	Thread myThread;
	double velRobo = 6 * 1000 / 3600; // 6 km/h

	public GuaraSimulation() {

		GuaraRobot Guara = new GuaraRobot();
		System.out.println("guaraRobot Guara = new guaraRobot();");
		sim = new SimulationConstructionSet(Guara);
		System.out.println("sim = new SimulationConstructionSet(Guara);");
//		Guara.setController(new guaraController(Guara));
		System.out.println("Guara.setController");
		sim.setGroundVisible(true);
		sim.setCameraTracking(false, false, false, false);
		sim.setCameraDolly(false, false, false, false);
		sim.setCameraPosition(7.7, 4.5, 3.0);
		sim.setCameraFix(0.0, 0.0, 0.8);
		// sim.setCameraTrackingVars("ef_track00_x", "ef_track00_y",
		// "ef_track00_z");

		sim.setDT(0.0004, 1000); //
		myThread = new Thread(sim);
		myThread.start();
	}


   public static void main(String[] args) throws SimulationExceededMaximumTimeException
   {
      GuaraSimulation guaraSimulation = new GuaraSimulation();
//      skippySimulation.run(TIME);
      ThreadTools.sleepForever();
   }


}
