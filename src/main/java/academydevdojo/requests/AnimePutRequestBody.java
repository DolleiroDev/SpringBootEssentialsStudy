package academydevdojo.requests;



import lombok.Data;

@Data
public class AnimePutRequestBody {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
}