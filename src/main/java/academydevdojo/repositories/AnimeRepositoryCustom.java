package academydevdojo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import academydevdojo.models.Anime;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AnimeRepositoryCustom {

    private final EntityManager entityManager;

    public List<Anime> getByGenre(String genre) {
        String query = " SELECT a FROM anime a WHERE a.genre = :genre";
        TypedQuery<Anime> q = entityManager.createQuery(query, Anime.class);
        q.setParameter("genre", genre);

        return q.getResultList();
    }

    public List<Anime> filterByReleaseYear(String year) {
        String query = " SELECT a FROM anime a WHERE a.releaseYear = :releaseYear";
        TypedQuery<Anime> q = entityManager.createQuery(query, Anime.class);
        q.setParameter("releaseYear", year);

        return q.getResultList();
    }
}
