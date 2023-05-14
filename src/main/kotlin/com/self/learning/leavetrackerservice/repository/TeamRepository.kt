package com.self.learning.leavetrackerservice.repository

import com.self.learning.leavetrackerservice.model.Team
import org.springframework.data.mongodb.repository.MongoRepository

interface TeamRepository : MongoRepository<Team, String> {
    // return list of teams
    override fun findAll(): List<Team>
}
