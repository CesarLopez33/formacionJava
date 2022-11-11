package bosonit.extra1_batch.tiemporiesgo.mapper;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TiempoRiesgoDtoRowMapper implements RowMapper<TiempoRiesgoDTO> {
    @Override
    public TiempoRiesgoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        TiempoRiesgoDTO tiempoRiesgoDTO = new TiempoRiesgoDTO();
        tiempoRiesgoDTO.setLocation(rs.getString("location"));
        tiempoRiesgoDTO.setYearNum(rs.getInt("y"));
        tiempoRiesgoDTO.setMonthNum(rs.getInt("m"));
        tiempoRiesgoDTO.setNumTemperatures(rs.getInt("c"));
        tiempoRiesgoDTO.setTemperatureAvg(rs.getFloat("average"));
        return tiempoRiesgoDTO;
    }
}
