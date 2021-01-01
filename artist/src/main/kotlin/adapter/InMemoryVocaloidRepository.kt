package adapter

import domain.vocaloid.NotFoundVocaloidById
import domain.vocaloid.Vocaloid
import domain.vocaloid.VocaloidId
import domain.vocaloid.VocaloidRepository

class InMemoryVocaloidRepository : VocaloidRepository {
    private val inMemoryCache: HashMap<VocaloidId, Vocaloid> = hashMapOf()

    override fun vocaloidOfIdentity(id: VocaloidId): Vocaloid {
        return inMemoryCache[id] ?: throw NotFoundVocaloidById(id)
    }

    override fun save(vocaloid: Vocaloid) {
        this.inMemoryCache[vocaloid.id] = vocaloid
    }
}
