/**
 * 
 */
package edu.sju.tankwar;

import java.util.Stack;

/**
 * @author team_f
 *
 */
public class GameFactory{
	public static Stack<Shell> shellsFactory=new Stack<Shell>();	
	public synchronized static Shell createShells(){
		if(shellsFactory.size()==0)
			return new Shell();
		return shellsFactory.pop();
	}
}
