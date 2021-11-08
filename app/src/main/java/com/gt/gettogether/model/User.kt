package com.gt.gettogether.model

import java.time.Instant
import java.util.*

class User {
    var name: String? = null
    var imageUrl: String? = null
    var meetings: List<Meeting>? = null
    var createdDate: Date? = null

    // Empty constructor needed for Firestore serialization
    constructor()

    constructor(
        name: String?,
        imageUrl: String?,
        meetings: List<Meeting>?,
    ) {
        this.name = name
        this.imageUrl = imageUrl
        this.meetings = meetings
        this.createdDate = Date.from(Instant.now())
    }
}
