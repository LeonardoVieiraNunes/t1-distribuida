package com.distribuida.trabalho1.throttler;

import java.util.Timer;
import java.util.TimerTask;

public class Throttler {
	private final int period;
	private final CallsCounter callsCounter;

	public Throttler(int period, CallsCounter callsCounter) {
		this.period = period;
		this.callsCounter = callsCounter;
	}

	public void start() {
		new Timer(true).schedule(new TimerTask() {
			@Override
			public void run() {
				callsCounter.clearAll();
			}
		}, 0, period);
	}
}
