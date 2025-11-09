package minihris.example.mini_hris_project.modules.jabatan.service;

import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanRequest;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JabatanService {
    JabatanResponse createJabatan(JabatanRequest jabatanRequest);
    JabatanResponse getJabatanById(Long id);
    Page<JabatanResponse> getAllJabatan(Pageable pageable);
    JabatanResponse updateJabatan(Long id, JabatanRequest jabatanRequest);
    void deleteJabatan(Long id);
}