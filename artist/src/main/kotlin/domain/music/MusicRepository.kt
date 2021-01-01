package domain.music

import domain.music.Music
import domain.music.MusicId

interface MusicRepository {
    fun musicOfIdentity(id: MusicId): Music
    fun save(music: Music)
}
