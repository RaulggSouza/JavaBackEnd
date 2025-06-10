package br.ifsp.infection.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqliteBulletinDao implements BulletinDAO {
    @Override
    public void insert(BulletinDTO bulletinDTO) {
        String sql = "INSERT INTO bulletins (city, state, infected, deaths, icu_ratio, date) VALUES(?, ?, ?, ?, ?, ?)";
        try (var stmt = ConnectionFactory.prepareStatement(sql)){
            stmt.setString(1, bulletinDTO.city());
            stmt.setString(2, bulletinDTO.state().toString());
            stmt.setInt(3, bulletinDTO.infected());
            stmt.setInt(4, bulletinDTO.deaths());
            stmt.setDouble(5, bulletinDTO.icuRatio());
            stmt.setString(6, bulletinDTO.date().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer integer) {
        String sql = "DELETE FROM bulletins WHERE id = ?";
        try(var stmt = ConnectionFactory.prepareStatement(sql)) {
            stmt.setInt(1, integer);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(BulletinDTO bulletinDTO) {
        String sql = "UPDATE bulletins SET city = ?, state = ?, infected = ?, deaths = ?, icu_ratio = ? WHERE id = ?";
        try (var stmt = ConnectionFactory.prepareStatement(sql)){
            stmt.setString(1, bulletinDTO.city());
            stmt.setString(2, bulletinDTO.state().toString());
            stmt.setInt(3, bulletinDTO.infected());
            stmt.setInt(4, bulletinDTO.deaths());
            stmt.setDouble(5, bulletinDTO.icuRatio());
            stmt.setString(6, bulletinDTO.date().toString());
            stmt.setInt(7, bulletinDTO.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Integer integer) {
        String sql = "SELECT id FROM bulletins WHERE id = ?";
        try (var stmt = ConnectionFactory.prepareStatement(sql)){
            stmt.setInt(1, integer);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BulletinDTO> findAll(String condition) {
        return List.of();
    }
}
