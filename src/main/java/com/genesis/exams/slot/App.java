package com.genesis.exams.slot;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {    	
    	// Use the reels setup defined from requirement R1
    	Reel[] reels = prepare();
    	
    	// Create a `com.genesis.exams.slot.SlotMachine` instance in your main class
    	SlotMachine slotMachine = new SlotMachine(reels, new SimpleSpinner(), new SimpleEvaluator());
    	// Your main class should invoke `spin` method of your `com.genesis.exams.slot.SlotMachine` instance with a bet amount of 100.
    	SpinResult spinResult = slotMachine.spin(100);
    	
    	// You have to print the result of the spin.
    	System.out.println(format(spinResult));
    }

	public static Reel[] prepare() {
		Reel[] reels = new Reel[3];
    	reels[0] = new Reel(new Symbol[]{Symbols.A, Symbols.B, Symbols.C, Symbols.X, Symbols.Y, Symbols.Z});
    	reels[1] = new Reel(new Symbol[]{Symbols.Z, Symbols.Y, Symbols.X, Symbols.A, Symbols.B, Symbols.C});
    	reels[2] = new Reel(new Symbol[]{Symbols.A, Symbols.B, Symbols.C, Symbols.X, Symbols.Y, Symbols.Z});
		return reels;
	}
	
	public static String format(SpinResult spinResult) {
		String result = Stream.of(spinResult.getSymbols()).map(Symbol::getName).collect(Collectors.joining(","));
    	long payout = spinResult.getPayout();
        return ("The result of the spin: [" + result + "]. You wins: " + payout);
	}
    
}
