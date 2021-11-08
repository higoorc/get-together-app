package com.gt.gettogether.model

import java.time.Instant
import java.util.*

class Meeting {
    var code: Int? = null
    var title: String? = null
    var imageUrl: String? = null
    var participants: List<User>? = null
    var host: User? = null
    var createdDate: Date? = null
    var date: Date? = null
    var local: String? = null
    var chat: List<Message>? = null
    var media: List<Message>? = null
    var pools: List<Pool>? = null

    // Empty constructor needed for Firestore serialization
    constructor()

    constructor(
        title: String?,
        imageUrl: String?,
        participants: List<User>?,
        host: User,
        date: Date?,
        local: String?,
        pools: List<Pool>?
    ) {
        this.code = 123
        this.title = title
        this.imageUrl = imageUrl
        this.participants = participants
        this.host = host
        this.createdDate = Date.from(Instant.now())
        this.date = date
        this.local = local
        this.pools = pools
    }
}
