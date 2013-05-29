import groovy.transform.TypeChecked
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 5/28/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Unroll
class TypeUnitSpec extends Specification {


    void "test List<Long> typing #desc"() {

        given:
        List<Long> desiredTypeSafeList = [] as List<Long>

        when:
        desiredTypeSafeList.addAll(list)

        then:
        list.contains(valueToLookFor) == expectedFound

        where:
        desc                                             | list                | valueToLookFor    | expectedFound
        'long not found with list of literal BigInteger' | [123]               | Long.valueOf(123) | false
        'long not found with list of literal BigInteger' | [123]               | 123L              | false
        'long not found with list of literal BigInteger' | [123]               | 123l              | false
        'long not found with list of literal BigInteger' | [123G]              | Long.valueOf(123) | false

        'long found with list of literal Long'           | [123L]              | Long.valueOf(123) | true
        'long found with list of literal Long'           | [123l]              | Long.valueOf(123) | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | Long.valueOf(123) | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | 123L              | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | 123l              | true

        "ideally don't want this"                        | ['foo']             | 123l              | false


    }

    void "test List<Long> typing  with typing in method sig #desc"(String desc, List<Long> list, Long valueToLookFor, boolean expectedFound) {

        given:
        List<Long> desiredTypeSafeList = [] as List<Long>

        when:
        desiredTypeSafeList.addAll(list)

        then:
        list.contains(valueToLookFor) == expectedFound

        where:
        desc                                             | list                | valueToLookFor    | expectedFound
        'long not found with list of literal BigInteger' | [123]               | Long.valueOf(123) | false
        'long not found with list of literal BigInteger' | [123]               | 123L              | false
        'long not found with list of literal BigInteger' | [123]               | 123l              | false
        'long not found with list of literal BigInteger' | [123G]              | Long.valueOf(123) | false

        'long found with list of literal Long'           | [123L]              | Long.valueOf(123) | true
        'long found with list of literal Long'           | [123l]              | Long.valueOf(123) | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | Long.valueOf(123) | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | 123L              | true
        'long found with list of literal Long'           | [Long.valueOf(123)] | 123l              | true

        "ideally don't want this"                        | ['foo']             | 123l              | false


    }



}
