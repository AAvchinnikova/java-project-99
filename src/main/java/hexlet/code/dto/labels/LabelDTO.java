package hexlet.code.dto.labels;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LabelDTO {

    private long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
