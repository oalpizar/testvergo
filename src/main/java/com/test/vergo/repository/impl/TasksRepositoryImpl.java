package com.test.vergo.repository.impl;

import com.test.vergo.dto.TaskDTO;
import com.test.vergo.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TasksRepositoryImpl implements TasksRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TaskDTO> getTasks(){
        final String query = "SELECT ID,  DESCRIPTION,(SELECT NAME FROM STATUS WHERE ID = T.STATUS) AS  STATUS_NAME, " +
                "(SELECT NAME FROM USERS WHERE ID = T.ASSIGNE) AS ASSIGNE_NAME, (SELECT NAME FROM PRIORITY WHERE ID = T.PRIORITY)  " +
                "AS PRIORITY_NAME, STATUS, ASSIGNE, PRIORITY FROM TASK T;";

        return jdbcTemplate.query(query, new RowMapper<TaskDTO>() {
            @Override
            public TaskDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                int indice = 0;
                TaskDTO dto = new TaskDTO();
                dto.setId(rs.getInt(++indice));
                dto.setDescription(rs.getString(++indice));
                dto.setStatusName(rs.getString(++indice));
                dto.setAssigneName(rs.getString(++indice));
                dto.setPriorityName(rs.getString(++indice));
                dto.setStatus(rs.getInt(++indice));
                dto.setAssigne(rs.getInt(++indice));
                dto.setPriority(rs.getInt(++indice));
                return dto;
            }
        });
    }

    @Override
    public TaskDTO getTask(int idTask){
        final String query = "SELECT ID,  DESCRIPTION,(SELECT NAME FROM STATUS WHERE ID = T.STATUS) AS  STATUS_NAME, " +
                "(SELECT NAME FROM USERS WHERE ID = T.ASSIGNE) AS ASSIGNE_NAME, (SELECT NAME FROM PRIORITY WHERE ID = T.PRIORITY)  " +
                "AS PRIORITY_NAME, STATUS, ASSIGNE, PRIORITY FROM TASK T WHERE ID = ?;";

        TaskDTO dto = this.jdbcTemplate.queryForObject(
                query,
                new Object[] { idTask },
                new RowMapper<TaskDTO>() {
                    public TaskDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        TaskDTO dto = new TaskDTO();
                        dto.setId(rs.getInt("ID"));
                        dto.setDescription(rs.getString("DESCRIPTION"));
                        dto.setStatusName(rs.getString("STATUS_NAME"));
                        dto.setAssigneName(rs.getString("ASSIGNE_NAME"));
                        dto.setPriorityName(rs.getString("PRIORITY_NAME"));
                        dto.setStatus(rs.getInt("STATUS"));
                        dto.setAssigne(rs.getInt("ASSIGNE"));
                        dto.setPriority(rs.getInt("PRIORITY"));
                        return dto;
                    }
                });
        return dto;
    }

    @Override
    public int updateTask(TaskDTO dto, int idTask){
        final String query = "UPDATE TASK SET DESCRIPTION = ?, ASSIGNE= ?, STATUS= ?, PRIORITY= ?   WHERE ID = ?;";
        int result = jdbcTemplate.update(query, dto.getDescription(), dto.getAssigne(), dto.getStatus(), dto.getPriority(), idTask);
        return result;
    }

    @Override
    public int countUserTask(int idUser){
        final String query = "select count(*) from TASK where ASSIGNE = ?;";
        return jdbcTemplate.queryForObject(query, new Object[] { idUser }, Integer.class);
    }

}
