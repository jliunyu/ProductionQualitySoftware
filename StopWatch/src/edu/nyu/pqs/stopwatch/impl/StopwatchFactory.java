package edu.nyu.pqs.stopwatch.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.Collections;

import edu.nyu.pqs.stopwatch.api.IStopwatch;

/**
 * The StopwatchFactory is a thread-safe factory class for IStopwatch objects.
 * It maintains references to all created IStopwatch objects and provides a
 * convenient method for getting a list of those objects.
 *
 */
public class StopwatchFactory {

	public static List<IStopwatch> list = Collections.synchronizedList(new ArrayList<IStopwatch>());
	static Hashtable<String, IStopwatch> istopwatchHash = new Hashtable<String, IStopwatch>(); 
	/**
	 * Creates and returns a new IStopwatch object
	 * @param id The identifier of the new object
	 * @return The new IStopwatch object
	 * @throws IllegalArgumentException if <code>id</code> is empty, null, or already taken
	 */
	public synchronized static IStopwatch getStopwatch(String id) {
		if(id.isEmpty()||istopwatchHash.containsKey(id) ){
			throw new IllegalStateException();
		}
		else{
			IStopwatch stopwatch = new StopWatch();
			list.add(stopwatch);
			istopwatchHash.put(id,stopwatch);			
			return stopwatch;
		}
	}


	/**
	 * Returns a list of all created stopwatches
	 * @return a List of al creates IStopwatch objects.  Returns an empty
	 * list oi no IStopwatches have been created.
	 */
	public List<IStopwatch> getStopwatches() {
		if(list.isEmpty()){
		return null;
		}
		else{
			return Collections.unmodifiableList(list);
		}
	}
}
