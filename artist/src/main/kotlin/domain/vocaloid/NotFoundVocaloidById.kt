package domain.vocaloid

class NotFoundVocaloidById(vocaloidId: VocaloidId) : Exception("can't found vocaloid using id: $vocaloidId")
