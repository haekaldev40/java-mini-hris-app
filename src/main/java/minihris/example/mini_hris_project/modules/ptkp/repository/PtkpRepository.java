package minihris.example.mini_hris_project.modules.ptkp.repository;

import minihris.example.mini_hris_project.modules.ptkp.entity.TrPtkp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtkpRepository extends JpaRepository<TrPtkp, Long> {
}