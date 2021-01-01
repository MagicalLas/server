package adapter

import domain.artist.*

class InMemoryArtistRepository : ArtistRepository {
    private val inMemoryCache: HashMap<ArtistId, Artist> = hashMapOf()

    override fun artistOfIdentity(id: ArtistId): Artist {
        return inMemoryCache[id] ?: throw NotFoundArtistById(id)
    }

    override fun findByName(artistName: String): Artist {
        return this.inMemoryCache.values.firstOrNull { x -> x.name == artistName }
                ?: throw NotFoundArtistByName(artistName)

    }

    override fun save(artist: Artist) {
        this.inMemoryCache[artist.id] = artist
    }
}
