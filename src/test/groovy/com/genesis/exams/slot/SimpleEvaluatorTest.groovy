package com.genesis.exams.slot

import spock.lang.Specification

class SimpleEvaluatorTest extends Specification {

    def "The payout will be calcutated according to it's Bet Multiplier"() {
        setup:
        def evaluator = new SimpleEvaluator();
        def symbols = [Symbols."${a}", Symbols."${b}", Symbols."${c}"] as Symbol[]
		
        when:
        def payout = evaluator.evaluate(symbols, 100)

        then:
        payout == d
        
        where:
        a   | b   | c   || d
        "A" | "A" | "A" || 2000
        "B" | "B" | "B" || 2000
        "C" | "C" | "C" || 2000
        "A" | "B" | "C" || 3000
    }
    
    def "There is no payout if the spin result is not a winning one"() {
        setup:
        def evaluator = new SimpleEvaluator();
        def symbols = [Symbols."${a}", Symbols."${b}", Symbols."${c}"] as Symbol[]
		
        when:
        def payout = evaluator.evaluate(symbols, 100)

        then:
        payout == d
        
        where:
        a   | b   | c   || d
        "X" | "X" | "X" || 0
        "Y" | "Y" | "Y" || 0
        "Z" | "Z" | "Z" || 0
    }
    
}
