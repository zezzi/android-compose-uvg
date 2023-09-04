package com.zezzi.eventzezziapp.ui.concerts.model

data class Concert(
    val id: Long,
    val tourName: String,
    val artist: String,
    val dateDetails: List<ConcertDetail>,
    val description: String,
    val concertImage: Int,
    val imageUrl: String? = null,
)

data class ConcertDetail(val date: String,
                         val venue: String,
                         val time: String,
                         val availableSeats: Int)