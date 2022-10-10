package bosonit.fileData.service;

import bosonit.fileData.dtos.output.FileDataOutputDTO;
import bosonit.exceptions.StorageException;
import bosonit.fileData.FileData;
import bosonit.fileData.dtos.input.FileDataInputDTO;
import bosonit.fileData.dtos.output.FileOutputDTO;
import bosonit.fileData.repository.FileDataRepository;
import bosonit.storageService.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl implements FileService{
    @Autowired
    FileDataRepository fileDataRepository;
    @Autowired
    StorageService storageService;
    @Override
    public FileDataOutputDTO subirFichero(FileDataInputDTO file) {
        storageService.store(file.getFile());
        FileData f = new FileData(file);
        fileDataRepository.save(f);
        return new FileDataOutputDTO(f);
    }

    @Override
    public FileOutputDTO bajarFicheroId(Integer id) {
        FileData f = fileDataRepository.findById(id)
                .orElseThrow(()-> new StorageException("Fichero no encontrado con id: " + id));
        return new FileOutputDTO(f,storageService.loadAsResource(f.getName()));
    }

    @Override
    public FileOutputDTO bajarFicheroNombre(String nombre) {
        FileData f = fileDataRepository.findFirstByName(nombre)
                .orElseThrow(()->new StorageException("Fichero con nombre " + nombre + " no encontrado"));
        return new FileOutputDTO(f ,storageService.loadAsResource(nombre));
    }
}
