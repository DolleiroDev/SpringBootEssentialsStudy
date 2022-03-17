package academydevdojo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academydevdojo.models.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}