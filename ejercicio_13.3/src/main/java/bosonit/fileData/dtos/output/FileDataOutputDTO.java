package bosonit.fileData.dtos.output;

import bosonit.fileData.FileData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FileDataOutputDTO implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private long size;
    private Date uploadDate;
    private String category;
    private String downloadURL;


    public FileDataOutputDTO(FileData f) {
        this.id = f.getId();
        this.name = f.getName();
        this.type = f.getType();
        this.size = f.getSize();
        this.uploadDate = f.getUploadDate();
        this.category = f.getCategory();
    }
}
