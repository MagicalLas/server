package domain.artist

class Artist(val id: ArtistId, var name: String) {
    fun changeName(newName: String) {
        this.name = newName
    }
}
