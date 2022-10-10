package bosonit.fileData.service;

import bosonit.fileData.dtos.output.FileDataOutputDTO;
import bosonit.fileData.dtos.input.FileDataInputDTO;
import bosonit.fileData.dtos.output.FileOutputDTO;


public interface FileService {
    public FileDataOutputDTO subirFichero(FileDataInputDTO file);
    public FileOutputDTO bajarFicheroId(Integer id);
    public FileOutputDTO bajarFicheroNombre(String nombre);
}
