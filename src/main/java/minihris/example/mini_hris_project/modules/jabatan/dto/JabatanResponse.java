package minihris.example.mini_hris_project.modules.jabatan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JabatanResponse {
    private Long id;
    private String kodeJabatan;
    private String namaJabatan;
}