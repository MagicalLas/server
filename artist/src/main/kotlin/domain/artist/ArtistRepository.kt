package domain.artist

import domain.artist.Artist
import domain.artist.ArtistId

interface ArtistRepository {
    fun artistOfIdentity(id: ArtistId): Artist
    fun findByName(artistName: String): Artist
    fun save(artist: Artist)
}
