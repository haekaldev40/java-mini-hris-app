package minihris.example.mini_hris_project.modules.jabatan.repository;

import minihris.example.mini_hris_project.modules.jabatan.entity.TrJabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanRepository extends JpaRepository<TrJabatan, Long> {
}