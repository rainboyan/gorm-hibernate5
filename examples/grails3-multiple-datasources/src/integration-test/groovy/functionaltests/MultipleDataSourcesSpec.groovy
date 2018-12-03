package functionaltests


import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.*
import example.Book
import ds2.Book as SecondBook

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class MultipleDataSourcesSpec extends Specification {


    void "Test multiple data source persistence"() {
        when:
            new Book(title:"One").save(flush:true)
            new Book(title:"Two").save(flush:true)
            new SecondBook(title:"Three").save(flush:true)

        then:
            Book.count() == 2
            SecondBook.count() == 1
            SecondBook.secondary.count() == 1
    }
}