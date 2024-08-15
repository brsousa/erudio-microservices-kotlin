package br.com.erudio.model

import jakarta.persistence.*

@Entity
@Table(name = "person_table")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 30)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 30)
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(nullable = false, length = 9)
    var gender: String = ""
)
