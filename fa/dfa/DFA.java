package fa.dfa;

import java.util.*;

import fa.State;

/**
* <h1>DFA!</h1>
* The DFA class is responsible for implementing the DFAInterface.
* Methods associated with this class allow for adding and traversing State objects.
*
* @author Jeff Kahn
* @author Jackson Edwards
* @version 1.0
* @since   2021-02-27
*/
public class DFA implements DFAInterface {

	private Set<DFAState> StateContainer = new LinkedHashSet<DFAState>();
	private Set<DFAState> FinalStateContainer = new LinkedHashSet<DFAState>();
	private Set<Character> AlphabetContainer = new LinkedHashSet<Character>();
	DFAState startState = new DFAState();
	
	@Override
	public void addStartState(String name) {
		this.startState.setName(name);
		this.startState.setStart(true);

		if ((!StateContainer.contains(getState(name)))) {

			StateContainer.add(startState);
		} else {
			if (getState(name).isFinalState) {
				this.startState.setFinal(true);
			}
			getState(name).setStart(true);
		}
	}

	@Override
	public void addState(String name) {
		DFAState newState = new DFAState();
		newState.setName(name);

		if (!(StateContainer.contains(getState(name)))) {
			StateContainer.add(newState);
		}
	}

	@Override
	public void addFinalState(String name) {
		DFAState newState = new DFAState(); // make new state
		newState.setName(name); // set name
		newState.setFinal(true); // set it as a final state

		if (!(StateContainer.contains(getState(name)))) {
			StateContainer.add(newState);
		}
		FinalStateContainer.add(newState); // add it to the container
	}
	/**
	* This method returns a DFAState when given a 
	* valid name. Searches through our State Container
	* to find the matching DFAState.
	* @param name This is what we are searching for 
	* @return returns the DFAState with the corresponding name
	*/
	private DFAState getState(String name) {
		DFAState rState = null;
		for (DFAState s : StateContainer) {
			if (s.getName().equals(name)) {
				rState = s;
			}
		}
		return rState;
	}
	/**
	* getFinalState returns a DFAState that has 
	* the matching name of our parameter. 
	* @param name is what we are searching for in 
	* our finalStateContainer.
	* @return returns the DFAState with the corresponding name.
	*/
	private DFAState getFinalState(String name) {
		DFAState rState = null;
		for (DFAState s : FinalStateContainer) {
			if (s.getName().equals(name)) {
				rState = s;
			}
		}
		return rState;
	}

	@Override
	public void addTransition(String fromState, char onSymb, String toState) {
		
		AlphabetContainer.add(onSymb);
		getState(fromState).setTransition(onSymb, getState(toState));
		if (fromState.equals(startState.getName())) {
			startState = getState(fromState);
		}

	}

	@Override
	public Set<? extends State> getStates() {
		
		return StateContainer;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		
		return FinalStateContainer;
	}

	@Override
	public State getStartState() {
		
		return startState;
	}

	@Override
	public Set<Character> getABC() {
		

		return AlphabetContainer;
	}

	@Override
	public boolean accepts(String s) {
		
		boolean accepts = false;
		DFAState currentState = startState;
		char[] stringInput = s.toCharArray();
		// traverse through the given string
		for (int i = 0; i < s.length(); i++) {
			// see if each string will result in a valid state?
			char currentChar = s.charAt(i);
			if (currentChar != 'e') {
				currentState = (DFAState) getToState(currentState, currentChar);
			}
			if (currentState == null) {
				return accepts;
			}
		}
		// once we reach the end of the string
		if (currentState.isFinal()) {
			accepts = true;
			return accepts;
		}
		// current state is not final.
		return accepts;
	}

	@Override
	public State getToState(DFAState from, char onSymb) {
		
		return from.getTransition(onSymb);

	}
	/**
	 * Displays the states, alphabet, transitions, start, and final states of the DFA
	 * @return returns the formated states,alphabet,transitions,start,and final states.
	 */
	public String toString() {
		// initial set up for printing
		String states = "Q = { ";
		String alphabet = "Sigma = { ";
		String delta = "delta = \n";
		String startingSpot = "q0 = ";
		String fStates = "F = { ";

		// gather our initial states
		for (DFAState state : StateContainer) {
			states += state.getName() + " ";
			if (state.isStart()) {
				startingSpot += state.getName();
			}
			if (state.isFinal()) {
				fStates += state.getName() + " ";
			}
		}
		for (char symb : AlphabetContainer) {
			alphabet += symb + " ";
		}
		delta += "\t\t";
		for (char symb : AlphabetContainer) {
			delta += symb + "\t";

		}
		delta += "\n";
		for (DFAState state : StateContainer) {
			delta += "\t" + state.getName() + "\t";
			for (char symb : AlphabetContainer) {
				delta += state.getTransition(symb) + "\t";
			}
			delta += "\n";
		}
		String ret = "";
		ret += states + "}\n";
		ret += alphabet + "}\n";
		ret += delta + "\n";
		ret += startingSpot + "\n";
		ret += fStates + "}\n";

		return ret;
	}

}
