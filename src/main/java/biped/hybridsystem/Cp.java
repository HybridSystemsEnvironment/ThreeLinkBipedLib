
package biped.hybridsystem;

import biped.computations.BipedComputer;
import edu.ucsc.cross.hse.core.modeling.FlowSet;

/**
 * A flow set
 */
public class Cp implements FlowSet<BipedState> {

	/**
	 * Parameters
	 */
	public Parameters parameters;

	/**
	 * Constructor for flow set
	 */
	public Cp(Parameters parameters) {

		this.parameters = parameters;
	}

	/**
	 * Flow set
	 * 
	 * @param x
	 *            current state
	 */
	@Override
	public boolean C(BipedState x) {

		boolean inC = true;
		double hVal = BipedComputer.computeStepRemainder(x, parameters);
		inC = hVal >= 0.0;
		return inC;
	}

}
