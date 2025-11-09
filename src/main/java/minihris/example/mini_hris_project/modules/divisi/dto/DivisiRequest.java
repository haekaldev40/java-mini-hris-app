package minihris.example.mini_hris_project.modules.divisi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisiRequest {
    private String name;
    private String kodeDivisi;
}