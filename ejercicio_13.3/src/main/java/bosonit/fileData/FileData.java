package bosonit.fileData;

import bosonit.fileData.dtos.input.FileDataInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class FileData {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private long size;
    @Column
    private Date uploadDate;
    @Column
    private String category;

    public FileData(FileDataInputDTO file){
        this.name=file.getFile().getOriginalFilename();
        this.type=file.getFile().getContentType();
        this.size = file.getFile().getSize();
        this.uploadDate = new Date();
        this.category = file.getCategory();
    }
}
