package adapter

import domain.music.Music
import domain.music.MusicId
import domain.music.MusicRepository
import domain.music.NotFoundMusicById

class InMemoryMusicRepository : MusicRepository {
    private val inMemoryCache: HashMap<MusicId, Music> = hashMapOf()

    override fun musicOfIdentity(id: MusicId): Music {
        return inMemoryCache[id] ?: throw NotFoundMusicById(id)
    }

    override fun save(music: Music) {
        this.inMemoryCache[music.id] = music
    }
}
