package com.self.learning.leavetrackerservice.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "team")
class Team(
        val uuid: UUID,
        val name: String,
)
