package domain.vocaloid

interface VocaloidRepository {
    fun vocaloidOfIdentity(id: VocaloidId): Vocaloid
    fun save(vocaloid: Vocaloid)
}
