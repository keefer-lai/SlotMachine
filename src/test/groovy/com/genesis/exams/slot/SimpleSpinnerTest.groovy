package com.genesis.exams.slot

import spock.lang.Specification

class SimpleSpinnerTest extends Specification {

    def "Spin a reel that contains one symbol"() {
        setup:
        def spinner = new SimpleSpinner()
        def symbols = [Symbols."${a}"] as Symbol[]
        def reel = new Reel(symbols)
		
        when:
        def symbol = spinner.spin(reel)

        then:
        symbol != null && symbol == Symbols."${a}"
        
        where:
        a   | _ 
        "A" | _ 
        "B" | _
        "C" | _
        "X" | _ 
        "Y" | _ 
        "Z" | _
    }
    
    def "Spin a reel that contains two symbols"() {
        setup:
        def spinner = new SimpleSpinner()
        def symbols = [Symbols."${a}", Symbols."${b}"] as Symbol[]
        def reel = new Reel(symbols)
		
        when:
        def symbol = spinner.spin(reel)

        then:
        symbol != null && symbols.contains(symbol)
        
        where:
        a   | b   
        "A" | "B"  
        "B" | "C" 
        "C" | "X" 
        "X" | "Y"
        "Y" | "Z" 
    }
    
    def "Spin a reel that contains three symbols"() {
        setup:
        def spinner = new SimpleSpinner()
        def symbols = [Symbols."${a}", Symbols."${b}", Symbols."${c}"] as Symbol[]
        def reel = new Reel(symbols)
		
        when:
        def symbol = spinner.spin(reel)

        then:
        symbol != null && symbols.contains(symbol)
        
        where:
        a   | b   | c 
        "A" | "B" | "C" 
        "B" | "C" | "X"
        "C" | "X" | "Y"
        "X" | "Y" | "Z"
    }
    
    def "Spin a reel that contains all symbols"() {
        setup:
        def spinner = new SimpleSpinner()
        def symbols = [Symbols."${a}", Symbols."${b}", Symbols."${c}", Symbols."${d}", Symbols."${e}", Symbols."${f}"] as Symbol[]
        def reel = new Reel(symbols)
		
        when:
        def symbol = spinner.spin(reel)

        then:
        symbol != null && symbols.contains(symbol)
        
        where:
        a   | b   | c   | d   | e   | f
        "A" | "B" | "C" | "X" | "Y" | "Z"
		"Z" | "Y" | "X" | "A" | "B" | "C"
    }
    
}
