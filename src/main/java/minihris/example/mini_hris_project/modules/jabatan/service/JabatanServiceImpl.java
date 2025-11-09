package minihris.example.mini_hris_project.modules.jabatan.service;

import lombok.RequiredArgsConstructor;
import minihris.example.mini_hris_project.exception.ResourceNotFoundException;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanRequest;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanResponse;
import minihris.example.mini_hris_project.modules.jabatan.entity.TrJabatan;
import minihris.example.mini_hris_project.modules.jabatan.mapper.JabatanMapper;
import minihris.example.mini_hris_project.modules.jabatan.repository.JabatanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JabatanServiceImpl implements JabatanService {

    private final JabatanRepository jabatanRepository;
    private final JabatanMapper jabatanMapper;

    @Override
    @Transactional
    public JabatanResponse createJabatan(JabatanRequest jabatanRequest) {
        TrJabatan jabatan = jabatanMapper.toEntity(jabatanRequest);
        return jabatanMapper.toResponse(jabatanRepository.save(jabatan));
    }

    @Override
    @Transactional(readOnly = true)
    public JabatanResponse getJabatanById(Long id) {
        TrJabatan jabatan = jabatanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jabatan not found with id: " + id));
        return jabatanMapper.toResponse(jabatan);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JabatanResponse> getAllJabatan(Pageable pageable) {
        return jabatanRepository.findAll(pageable).map(jabatanMapper::toResponse);
    }

    @Override
    @Transactional
    public JabatanResponse updateJabatan(Long id, JabatanRequest jabatanRequest) {
        TrJabatan jabatan = jabatanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jabatan not found with id: " + id));
        jabatanMapper.updateEntity(jabatan, jabatanRequest);
        return jabatanMapper.toResponse(jabatanRepository.save(jabatan));
    }

    @Override
    @Transactional
    public void deleteJabatan(Long id) {
        TrJabatan jabatan = jabatanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jabatan not found with id: " + id));
        jabatanRepository.delete(jabatan);
    }
}