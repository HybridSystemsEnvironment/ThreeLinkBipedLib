package edu.ucsc.hsl.hse.model.biped.threelink.systems;

import edu.ucsc.cross.hse.core.modeling.DataStructure;
import edu.ucsc.hsl.hse.model.biped.threelink.states.BipedState;
import edu.ucsc.hsl.hse.model.biped.threelink.states.VirtualBipedState;

public class ClosedLoopBipedState extends DataStructure
{

	public BipedState realBiped;
	public VirtualBipedState virtualBiped;

	public ClosedLoopBipedState(BipedState real_biped, VirtualBipedState virtual_biped)
	{
		realBiped = real_biped;
		virtualBiped = virtual_biped;
		realBiped.getProperties().setStoreTrajectory(true);
		virtualBiped.getProperties().setStoreTrajectory(true);
		realBiped.getProperties().setName("Real State");
		virtualBiped.getProperties().setName("Virtual State");
	}

}
