package minihris.example.mini_hris_project.modules.ptkp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtkpRequest {
    private String status;
    private String keterangan;
    private BigDecimal nilaiPtkp;
}