package bosonit.fileData.repository;

import bosonit.fileData.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    public Optional<FileData> findFirstByName(String name);
}
