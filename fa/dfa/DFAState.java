package fa.dfa;

import java.util.HashMap;

import fa.State;

/**
* <h1>DFAState!</h1>
* The DFAState class is used to represent a state object.
* Each state contains information such as name, start, final and transition details in a map
*
* @author Jeff Kahn
* @author Jackson Edwards
* @version 1.0
* @since   2021-02-27
*/
public class DFAState extends State {
	boolean isStartState = false;
	boolean isFinalState = false;
	HashMap<Character, DFAState> map = new HashMap<Character, DFAState>();

	/**
	* sets name of state
	* @param name is the new name.
	*/
	void setName(String name) {
		this.name = name;
	}
	/**
	* setFinal changes the boolean final status of a state
	* @param status will set the final state to true or false
	*/
	void setFinal(boolean status) {
		this.isFinalState = status;
	}
	/**
	* setStart changes the boolean start status of a state
	* @param status will set the final state to true or false
	*/
	void setStart(boolean status) {
		this.isStartState = status;
	}
	/**
	 * Provides information regarding the status of if the state is a start state
	 * @return boolean with true or false depending on if state is start
	 */
	boolean isStart() {
		return isStartState;
	}
	/**
	* isFinal returns the status of a state
	* @return boolean with true or false depending on if state is final
	*/
	boolean isFinal() {
		return isFinalState;
	}
	/**
	 * Stores transition information from this state in the map
	 * @param symb character with transition
	 * @param toState State this State transitions to
	 */
	void setTransition(Character symb, DFAState toState) {
		this.map.put(symb, toState);
	}
	/**
	 * getTransition() returns a DFAState on the given symbol.
	 * @param onSymb is the char that we are searching for in the map
	 * @return the dfa state that corresponds with the given symbol. 
	 */
	DFAState getTransition(char onSymb) {
		return this.map.get(onSymb);
	}

}
