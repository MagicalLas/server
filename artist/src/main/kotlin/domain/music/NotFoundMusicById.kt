package domain.music

class NotFoundMusicById(musicId: MusicId) : Exception("can't found music using id: $musicId")
