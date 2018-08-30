
package biped.virtual.hybridsystem;

import biped.computations.BipedComputer;
import edu.ucsc.cross.hse.core.modeling.JumpSet;
import edu.ucsc.cross.hse.core.modeling.Output;
import edu.ucsc.hsl.hse.model.biped.threelink.factories.Zero;

/**
 * A jump set
 */
public class Dp implements JumpSet<State> {

	/**
	 * Parameters
	 */
	public Parameters parameters;

	public Output<biped.hybridsystem.State> input;

	/**
	 * Constructor for jump set
	 */
	public Dp(Parameters parameters) {

		this.parameters = parameters;
	}

	/**
	 * Constructor for jump set
	 */
	public Dp(Parameters parameters, Output<biped.hybridsystem.State> input) {

		this.parameters = parameters;
	}

	/**
	 * Flow set
	 * 
	 * @param x
	 *            current state
	 */
	@Override
	public boolean D(State x) {

		boolean inD = false; // add logic to determine if x in jump set
		biped.hybridsystem.State trigger = x.bipedState;
		if (input != null) {
			if (input.y() != null) {
				trigger = input.y();
			}
		}
		double hVal = BipedComputer.computeStepRemainder(trigger, parameters.bipedParams);
		inD = Zero.equal(hVal) && trigger.plantedLegVelocity >= 0.0;
		return inD;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(Output<biped.hybridsystem.State> input) {

		this.input = input;
	}

}
