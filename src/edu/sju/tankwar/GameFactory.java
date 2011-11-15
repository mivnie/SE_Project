/**
 * 
 */
package edu.sju.tankwar;

import java.util.Stack;

/**
 * @file GameFactory.java
 * @brief GameFactory to produce shells
 * @author 
 	The team name Team F
	The principal author's name : Suhao Qin
	Acknowledgement of help from other team members, by name: n/a
 * @version 1.0 
 */
public class GameFactory {
	public static Stack<Shell> shellsFactory = new Stack<Shell>();

	public synchronized static Shell createShells() {
		if (shellsFactory.size() == 0)
			return new Shell();
		return shellsFactory.pop();
	}
}
