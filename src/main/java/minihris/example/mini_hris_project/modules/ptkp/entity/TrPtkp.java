package minihris.example.mini_hris_project.modules.ptkp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tr_ptkp")
@Data
@NoArgsConstructor
public class TrPtkp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", length = 10, nullable = false, unique = true)
    private String status;

    @Column(name = "keterangan", length = 255)
    private String keterangan;

    @Column(name = "nilai_ptkp", precision = 15, scale = 2, nullable = false)
    private BigDecimal nilaiPtkp;
}