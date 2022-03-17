package academydevdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import academydevdojo.models.Anime;
import academydevdojo.repositories.AnimeRepository;
import academydevdojo.repositories.AnimeRepositoryCustom;
import academydevdojo.requests.AnimePostRequestBody;
import academydevdojo.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private AnimeRepositoryCustom animeRepositoryCustom;

    public List<Anime> listAllAnimes() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequest(long id) {
        return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found :(!"));
    }

    public Anime create(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder()
        .name(animePostRequestBody.getName())
        .genre(animePostRequestBody.getGenre())
        .releaseYear(animePostRequestBody.getReleaseYear())
        .build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody) {
        findByIdOrThrowBadRequest(animePutRequestBody.getId());
        Anime anime = Anime.builder()
            .id(animePutRequestBody.getId())
            .name(animePutRequestBody.getName())
            .genre(animePutRequestBody.getGenre())
            .releaseYear(animePutRequestBody.getReleaseYear())
            .build();
        animeRepository.save(anime);
    }

    public List<Anime> getByGenre(String name) {
        return animeRepositoryCustom.getByGenre(name);
    }

    public List<Anime> filterByReleaseYear(String year) {
        return animeRepositoryCustom.filterByReleaseYear(year);
    }
}
