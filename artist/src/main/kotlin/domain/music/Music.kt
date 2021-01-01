package domain.music

import domain.vocaloid.VocaloidId
import domain.artist.ArtistId

class Music(
        val id: MusicId,
        val artistId: List<ArtistId>,
        val title: String,
        val explain: String,
        val sourceLink: String
) {
    private val featuringList: MutableSet<ArtistId> = mutableSetOf()
    private val vocaloidList: MutableSet<VocaloidId> = mutableSetOf()

    fun featuring(artistId: ArtistId) {
        this.featuringList.add(artistId)
    }

    fun sing(vocaloidId: VocaloidId) {
        this.vocaloidList.add(vocaloidId)
    }
}
