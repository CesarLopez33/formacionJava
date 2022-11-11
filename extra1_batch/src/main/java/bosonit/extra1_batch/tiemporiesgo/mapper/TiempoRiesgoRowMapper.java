package bosonit.extra1_batch.tiemporiesgo.mapper;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TiempoRiesgoRowMapper implements RowMapper<TiempoRiesgo> {
    @Override
    public TiempoRiesgo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TiempoRiesgo tiempoRiesgo = new TiempoRiesgo();
        tiempoRiesgo.setLocation(rs.getString("location"));
        tiempoRiesgo.setYearNum(rs.getInt("year_num"));
        tiempoRiesgo.setMonthNum(rs.getInt("month_num"));
        tiempoRiesgo.setNumTemperatures(rs.getInt("num_temperatures"));
        tiempoRiesgo.setTemperatureAvg(rs.getFloat("temperature_avg"));
        tiempoRiesgo.setRisk(rs.getString("risk"));
        return tiempoRiesgo;
    }
}
