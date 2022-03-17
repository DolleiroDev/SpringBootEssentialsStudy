package academydevdojo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "This field can't be empty")
    @NotNull(message = "This field cant be null")
    private String name;

    @NotEmpty(message = "This field can't be empty")
    @NotNull(message = "This field cant be null")
    private String genre;

    @NotEmpty(message = "This field can't be empty")
    @NotNull(message = "This field cant be null")
    private String releaseYear;
}