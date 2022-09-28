package bosonit.ejercicio_72.feign;

import bosonit.ejercicio_72.profesor.dtos.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cliente1",url="http://localhost:8080/")
public interface IFeignServer {
    @GetMapping("profesor/{id}")
    ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id);
}
