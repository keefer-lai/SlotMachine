package com.genesis.exams.slot;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleEvaluator implements Evaluator {

	@Override
	public long evaluate(Symbol[] symbols, long bet) {
		String result = Stream.of(symbols).map(Symbol::getName).collect(Collectors.joining(","));
		
		int multiplier = findMultiplier(bet, result);
		
		return bet * multiplier;
	}

	// Evaluate the payout using the requirements from R3
	private int findMultiplier(long bet, String result) {
		switch(result) {
		case "A,A,A":
		case "B,B,B":
		case "C,C,C":
			return 20;
		case "A,B,C":
			return 30;
		default:
			return 0;
		}
	}

}
