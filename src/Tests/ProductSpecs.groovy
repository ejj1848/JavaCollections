package Tests

import Pojo.Product
import spock.lang.Specification

/**
 * Created by Eric.Johnson on 7/14/2017.
 */
class ProductSpecs extends Specification {

    def product

    def setup(){
        product = new Product(1,"Door", 10)
    }
    def "Product weight should equal 10"() {
        given:
            def result = product.getWeight()

        expect:
            result == 10
    }

    def "Product id should equal 1"(){
        given:
            def result = product.getId()
        expect:
            result == 1
    }

    def "Product name should equal Door"(){
        given:
            def result = product.getName()
        expect:
            result == "Door"
    }

}
