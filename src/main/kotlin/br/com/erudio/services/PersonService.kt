package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Findind all people... ")
        val persons: MutableList<Person> = ArrayList()

        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Findind person... ")
        return repository.findById(id).orElseThrow { ResourceNotFoundException("No records found !") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with name ${person.firstName}")

        val personFound = repository.findById(person.id).orElseThrow { ResourceNotFoundException("No records found !") }
        personFound.firstName = person.firstName
        personFound.lastName = person.lastName
        personFound.address = person.address
        personFound.gender = person.gender

        return repository.save(personFound)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with name $id")
        val person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found !") }
        repository.delete(person)
    }
}
