package com.self.learning.leavetrackerservice.controller

import com.self.learning.leavetrackerservice.model.Team
import com.self.learning.leavetrackerservice.repository.TeamRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/teams")
class TeamController(
    private val teamRepository: TeamRepository,
) {
    // return list of teams
    @GetMapping("/")
    fun getAllTeams(): ResponseEntity<List<Team>> {
        val teams = teamRepository.findAll()
        return ResponseEntity.ok(teams)
    }
}
