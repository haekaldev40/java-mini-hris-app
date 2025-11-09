package minihris.example.mini_hris_project.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomApiResponse<T> {
    private String result;
    private String detail;
    private String path;
    private String date;
    private int code;
    private String version;
    private T data;
}