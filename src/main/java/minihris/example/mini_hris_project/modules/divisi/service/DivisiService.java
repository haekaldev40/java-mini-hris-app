package minihris.example.mini_hris_project.modules.divisi.service;

import minihris.example.mini_hris_project.modules.divisi.dto.DivisiRequest;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DivisiService {
    DivisiResponse createDivisi(DivisiRequest divisiRequest);
    DivisiResponse getDivisiById(Long id);
    Page<DivisiResponse> getAllDivisi(Pageable pageable);
    DivisiResponse updateDivisi(Long id, DivisiRequest divisiRequest);
    void deleteDivisi(Long id);
}