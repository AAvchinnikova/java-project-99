package hexlet.code.dto.task.statuses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusCreateDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 1, message = "Minimal name length is about 1 symbol")
    private String name;

    @NotBlank(message = "Slug is required")
    @Size(min = 1, message = "Minimal slug length is about 1 symbol")
    private String slug;
}
