package academydevdojo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academydevdojo.models.Anime;
import academydevdojo.requests.AnimePostRequestBody;
import academydevdojo.requests.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
