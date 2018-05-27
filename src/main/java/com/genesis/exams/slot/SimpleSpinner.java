package com.genesis.exams.slot;

import java.util.Random;
import java.util.stream.Stream;

public class SimpleSpinner implements Spinner {

	@Override
	public Symbol spin(Reel reel) {
		final Symbol[] symbols = reel.getSymbols();
		
		final int totalWeight = Stream.of(symbols).mapToInt(Symbol::getWeight).sum();
		final int randomWeight = 1 + new Random().ints(1, 0, totalWeight).findFirst().getAsInt();	
		
		return findSymbol(symbols, randomWeight);
	}

	private Symbol findSymbol(final Symbol[] symbols, final int randomWeight) {
		int cumulativeWeight = 0;
		Symbol stopLocation = null;
		
		for (Symbol symbol : symbols) {	
			cumulativeWeight = cumulativeWeight + symbol.getWeight();
			if (cumulativeWeight >= randomWeight) {
				stopLocation = symbol;
			}
		}
		
		return stopLocation;
	}
	
}
