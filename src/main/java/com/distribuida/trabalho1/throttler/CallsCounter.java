package com.distribuida.trabalho1.throttler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CallsCounter {
	private final Map<String, AtomicLong> clientCallsCount = new ConcurrentHashMap<>();

	public CallsCounter() {
		clientCallsCount.put("PRIORITARIO", new AtomicLong(0));
		clientCallsCount.put("COMUM", new AtomicLong(0));
		clientCallsCount.put("POSTERGADO", new AtomicLong(0));

	}

	public void incrementCount(String clientName) {
		clientCallsCount.get(clientName).incrementAndGet();
	}

	public long getCount(String clientName) {
		return clientCallsCount.get(clientName).get();
	}

	public void clearAll() {
		clientCallsCount.replaceAll((k, v) -> new AtomicLong(0));
	}
}
