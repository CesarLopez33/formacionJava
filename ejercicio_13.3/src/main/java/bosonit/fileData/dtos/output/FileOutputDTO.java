package bosonit.fileData.dtos.output;

import bosonit.fileData.FileData;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import java.util.Date;

@Data
@NoArgsConstructor
public class FileOutputDTO {
    private Integer id;
    private String name;
    private String type;
    private long size;
    private Date uploadDate;
    private String category;
    private Resource resource;
    public FileOutputDTO(FileData f, Resource resource) {
        this.id = f.getId();
        this.name = f.getName();
        this.type = f.getType();
        this.size = f.getSize();
        this.uploadDate = f.getUploadDate();
        this.category = f.getCategory();
        this.resource = resource;
    }
}
