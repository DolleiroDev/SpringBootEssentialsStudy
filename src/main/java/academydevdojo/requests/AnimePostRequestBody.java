package academydevdojo.requests;



import lombok.Data;

@Data
public class AnimePostRequestBody {
    private String name;
    private String genre;
    private String releaseYear;
}