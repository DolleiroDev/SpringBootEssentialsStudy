package academydevdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academydevdojo.models.Anime;
import academydevdojo.requests.AnimePostRequestBody;
import academydevdojo.requests.AnimePutRequestBody;
import academydevdojo.services.AnimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animes")
@RequiredArgsConstructor
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> getAll() {
        return ResponseEntity.ok(animeService.listAllAnimes());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequest(id));
    }

    @PostMapping
    public ResponseEntity<Anime> create(@RequestBody @Valid AnimePostRequestBody anime) {
        return new ResponseEntity<>(animeService.create(anime), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid AnimePutRequestBody animePutRequestBody){
        animeService.update(animePutRequestBody);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "animeGenre/{name}")
    public ResponseEntity<List<Anime>> filterByGenre(@PathVariable String name){
        return ResponseEntity.ok(animeService.getByGenre(name));
    }

    @GetMapping(path = "filterByReleaseYear/{year}")
    public ResponseEntity<List<Anime>> filterByReleaseYear(@PathVariable String year) {
        return ResponseEntity.ok(animeService.filterByReleaseYear(year));
    }

}