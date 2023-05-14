package com.self.learning.leavetrackerservice.controller

import com.self.learning.leavetrackerservice.model.Team
import com.self.learning.leavetrackerservice.repository.TeamRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TeamControllerTest @Autowired constructor(
        private val teamRepository: TeamRepository,
        private val restTemplate: TestRestTemplate,
) {
    private val defaultTeamId = UUID.randomUUID()

    @LocalServerPort
    protected var port: Int = 0

    @BeforeEach
    fun setUp() {
        teamRepository.deleteAll()
    }

    private fun getRootUrl(): String = "http://localhost:$port/api/v1/teams/"

    private fun createOneTeam() = teamRepository.save(Team(defaultTeamId, "Team-A"))

    @Test
    fun `should return all patients`() {
        createOneTeam()

        val response = restTemplate.getForEntity(
                getRootUrl(),
                List::class.java,
        )

        assertEquals(200, response.statusCode.value())
        assertNotNull(response.body)
        assertEquals(1, response.body?.size)
    }
}
