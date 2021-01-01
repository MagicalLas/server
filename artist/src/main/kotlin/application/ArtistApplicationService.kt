package application

import domain.artist.Artist
import domain.artist.ArtistId
import domain.artist.ArtistRepository
import domain.music.Music
import domain.music.MusicId
import domain.music.MusicRepository
import domain.vocaloid.Vocaloid
import domain.vocaloid.VocaloidId
import domain.vocaloid.VocaloidRepository

class ArtistApplicationService(
        private val artistRepository: ArtistRepository,
        private val musicRepository: MusicRepository,
        private val vocaloidRepository: VocaloidRepository,
) {
    fun enrollNewArtist(name: String): ArtistId {
        val newArtist = Artist(ArtistId("1"), name)
        this.artistRepository.save(newArtist)
        return newArtist.id
    }

    fun searchByName(name: String): ArtistId {
        return this.artistRepository.findByName(name).id
    }

    fun changeName(id: ArtistId, newName: String) {
        val artist = this.artistRepository.artistOfIdentity(id)
        artist.changeName(newName)
        this.artistRepository.save(artist)
    }

    fun presentNewMusic(artistId: ArtistId, title: String, explain: String, sourceLink: String): MusicId {
        val newMusic = Music(MusicId("1"), listOf(artistId), title, explain, sourceLink)
        this.musicRepository.save(newMusic)
        return newMusic.id
    }

    fun presentNewMusicWithSeveralArtist(artistList: List<ArtistId>, title: String, explain: String, sourceLink: String): MusicId {
        val newMusic = Music(MusicId("1"), artistList, title, explain, sourceLink)
        this.musicRepository.save(newMusic)
        return newMusic.id
    }

    fun presentNewMusicWithFeaturing(artistId: ArtistId, featuringArtistIdList: List<ArtistId>, title: String, explain: String, sourceLink: String): MusicId {
        val newMusic = Music(MusicId("1"), listOf(artistId), title, explain, sourceLink)
        featuringArtistIdList.forEach { featuringArtistId -> newMusic.featuring(featuringArtistId) }
        this.musicRepository.save(newMusic)
        return newMusic.id
    }

    fun enrollNewVocaloid(name: String): VocaloidId {
        val newVocaloid = Vocaloid(VocaloidId("1"), name)
        this.vocaloidRepository.save(newVocaloid)
        return newVocaloid.id
    }

    fun presentNewVocaloidSong(artistId: ArtistId, vocaloidId: VocaloidId, title: String, explain: String, sourceLink: String): MusicId {
        val newMusic = Music(MusicId("1"), listOf(artistId), title, explain, sourceLink)
        newMusic.sing(vocaloidId)
        this.musicRepository.save(newMusic)
        return newMusic.id
    }
}
