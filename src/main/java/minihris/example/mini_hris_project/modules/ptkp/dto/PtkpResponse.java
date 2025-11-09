package minihris.example.mini_hris_project.modules.ptkp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtkpResponse {
    private Long id;
    private String status;
    private String keterangan;
    private BigDecimal nilaiPtkp;
}