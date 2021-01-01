package domain.artist

import domain.artist.ArtistId

class NotFoundArtistById(artistId: ArtistId) : Exception("can't found artist using id: $artistId")
