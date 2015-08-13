package edu.nyu.pqs.stopwatch.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import edu.nyu.pqs.stopwatch.api.IStopwatch;

/**
 * Define a StopWatch class which is a thread-safe class
 * @author jingliu
 * 
 *
 */
public class StopWatch implements IStopwatch{
	
	private String ID;
	private long startTime = 0;
	private long stopTime = 0;
	private long lapTime = 0;
	private long storePressLapTime = 0;
	private long currentTime = 0;
	private long elapsedTime = 0;
	private List<Long> list = Collections.synchronizedList(new ArrayList<Long>());
	private boolean judgeStartorStop = false;
	private boolean judgelap = false;
	
	@Override
	/**
	 * get the ID of the Object
	 * @return the Id of this stopwatch.  Will never be empty or null.
	 */
	public synchronized String getId() {
		return this.ID;
	}
	
	/**
	 * Starts the stopwatch.
	 * @throws IllegalStateException if called when the stopwatch is already running
	 */
	public synchronized void start() {
		if(judgeStartorStop == true){
			throw new IllegalStateException();
		}
		else{
			startTime = System.currentTimeMillis();
			judgeStartorStop = true;
		}
	}

	/**
	 * Stores the time elapsed since the last time lap() was called
	 * or since start() was called if this is the first lap.
	 * @throws IllegalStateException if called when the stopwatch isn't running
	 */
	public synchronized void lap() {
			if(storePressLapTime == 0){
				judgelap = true;
				currentTime = System.currentTimeMillis();
				lapTime = currentTime - startTime;
				storePressLapTime = currentTime;
			}
			else{
				judgelap = true;
				currentTime = System.currentTimeMillis();
				lapTime = currentTime - storePressLapTime;
				storePressLapTime = currentTime;
			
			}
		if(judgeStartorStop == false){
			throw new IllegalStateException();
		}
		list.add(lapTime);
	}

	/**
	 * Stops the stopwatch (and records one final lap).
	 * @throws IllegalStateException if called when the stopwatch isn't running
	 */
	public synchronized void stop() {
		if(judgeStartorStop = false){
			throw new IllegalStateException();
		}
		else{
				stopTime = System.currentTimeMillis();
				if(judgelap == false){
					elapsedTime = stopTime - startTime;
					list.add(elapsedTime);
				}
				judgeStartorStop = false;
				judgelap = false;
		}
	}

	@Override
	/**
	 * Resets the stopwatch.  If the stopwatch is running, this method stops the
	 * watch and resets it.  This also clears all recorded laps.
	 */
	public synchronized void reset() {
			judgeStartorStop = false;
			startTime = 0;
			lapTime = 0;
			list.clear();
			stopTime = 0;
			storePressLapTime = 0;
			currentTime = 0;
	}

	/**
	 * Returns a list of lap times (in milliseconds).  This method can be called at
	 * any time and will not throw an exception.
	 * @return a list of recorded lap times or an empty list if no times are recorded.
	 */
	public synchronized List<Long> getLapTimes() {
		if(list.isEmpty()){
			return null;
		}
		else{
			return Collections.unmodifiableList(list);
		}
	}
	
	/**
	 * @return a string represent the stopwatch
	 */
	
	public String toString(){
		String lapTimes = null;
		for(int i = 0; i<list.size(); i++){
			lapTimes = lapTimes + list.indexOf(i) + " ";
		}
	   return "ID: " + ID + "\n" + "start time: " + startTime + "\n" + 
	       "lap time: " + lapTimes + " "; 
		}
		
	/**
	 * Tests for equality between the specified object and this stopwatch.
	 * @param the object o
	 * @return whether the two objects are equal
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (! (o instanceof StopWatch))
			return false;
		StopWatch sw = (StopWatch) o;
		synchronized (this) {
			return ID.equals(sw.ID)
					&& judgeStartorStop == sw.judgeStartorStop
					&& list.equals(sw.list)
					&& storePressLapTime == sw.storePressLapTime
					&& startTime == sw.startTime
					&& stopTime == sw.stopTime
					&& lapTime == sw.lapTime
					&& elapsedTime == sw.elapsedTime
					&& judgelap == sw.judgelap
					&& currentTime == sw.currentTime;
		}
	}
	
	/**
	 * @return a hashCode value for this stopwatch
	 */
	
	 public int hashCode(){
	    return Objects.hash(ID.hashCode(), list.hashCode(),
	    		Long.valueOf(startTime).hashCode(), Long.valueOf(stopTime).hashCode(), 
	    		Long.valueOf(lapTime).hashCode(), Long.valueOf(elapsedTime).hashCode(), 
	    		Long.valueOf(currentTime).hashCode(), Long.valueOf(storePressLapTime).hashCode(),
	    		Boolean.valueOf(judgeStartorStop).hashCode(), Boolean.valueOf(judgelap).hashCode());
	  }
}
