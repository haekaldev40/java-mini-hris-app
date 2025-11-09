package minihris.example.mini_hris_project.modules.divisi.repository;

import minihris.example.mini_hris_project.modules.divisi.entity.TrDivisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisiRepository extends JpaRepository<TrDivisi, Long> {
}