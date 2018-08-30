
package biped.virtual.hybridsystem;

import biped.computations.BipedComputer;
import edu.ucsc.cross.hse.core.modeling.Controller;
import edu.ucsc.cross.hse.core.modeling.JumpMap;

/**
 * A jump map
 */
public class Gp implements JumpMap<State> {

	/**
	 * Parameters
	 */
	public Parameters parameters;

	/**
	 * Controller
	 */
	Controller<State, TrajectoryParameters> controller;

	/**
	 * Constructor for jump map
	 */
	public Gp(Controller<State, TrajectoryParameters> controller, Parameters parameters) {

		this.controller = controller;
		this.parameters = parameters;
	}

	/**
	 * Jump map
	 * 
	 * @param x
	 *            current state
	 * @param x_plus
	 *            state update values
	 */
	@Override
	public void G(State x, State x_plus) {

		BipedComputer.computeChangeAtImpact(x.bipedState, x_plus.bipedState, parameters.bipedParams);
		TrajectoryParameters newTrajParams = controller.k(x);
		x_plus.trajectoryParameters.B0 = newTrajParams.B0;
		x_plus.trajectoryParameters.B1 = newTrajParams.B1;
		x_plus.trajectoryParameters.finalState = newTrajParams.getFinalState();
		x_plus.trajectoryParameters.initialState = newTrajParams.getInitialState();
		x_plus.trajTimer = 0.0;

	}

}
