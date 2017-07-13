package Tests

import Modules.Calculator
import spock.lang.Specification

/**
 * Created by Eric.Johnson on 7/13/2017.
 */
class CalculatorSpecs extends  Specification{

    def calculator
    def setup(){
        calculator = new Calculator()
    }
    def "Calculator 1 +1 = 2"(){
        given:
        def result = calculator.evaluate("1+1")

        expect:
            result == 2

    }
}
