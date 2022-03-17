package academydevdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academydevdojo.mapper.AnimeMapper;
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

    public Page<Anime> listAllAnimes(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public Anime findByIdOrThrowBadRequest(long id) {
        return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found :(!"));
    }

    public Anime create(AnimePostRequestBody animePostRequestBody) {
        
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody) {
        findByIdOrThrowBadRequest(animePutRequestBody.getId());

        animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePutRequestBody));
    }

    public List<Anime> getByGenre(String name) {
        return animeRepositoryCustom.getByGenre(name);
    }

    public List<Anime> filterByReleaseYear(String year) {
        return animeRepositoryCustom.filterByReleaseYear(year);
    }
}
