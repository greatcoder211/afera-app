package pl.afera.aferaapp.legacyCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.afera.aferaapp.Party;
import pl.afera.aferaapp.Politician;
import pl.afera.aferaapp.Scandal;
import pl.afera.aferaapp.repository.ScandalRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class JdbcScandalRepository implements ScandalRepository {
    private final JdbcTemplate jdbc;
    @Autowired
    public JdbcScandalRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Scandal save(Scandal scandal) {
        long scandalId = saveScandalInfo(scandal);
        scandal.setId(scandalId);
        for(Politician politician : scandal.getAssociatedPoliticians()) {
            savePoliticianToScandal(politician, scandalId);
        }
        for(Party party : scandal.getAssociatedPoliticalParties()){
            savePartyToScandal(party, scandalId);
        }
        return scandal;
    }

    public long saveScandalInfo(Scandal scandal) {
        PreparedStatementCreator psc =
                new PreparedStatementCreatorFactory(
                        "insert into Scandal (name, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney) values (?, ?, ?, ?, ?, ?, ?)",
                        Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.DECIMAL, Types.DECIMAL
                ).newPreparedStatementCreator(
                        Arrays.asList(
                                scandal.getName(),
                                Timestamp.valueOf(scandal.getCreatedAt()),
                                Timestamp.valueOf(scandal.getUpdatedAt()),
                                scandal.getEndYear(),
                                scandal.getConfirmedEmbezzledAmountOfMoney(),
                                scandal.getUnconfirmedEmbezzledAmountOfMoney()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
    private void savePoliticianToScandal(
            Politician politician, long scandalId) {
        jdbc.update(
                "insert into Scandal_Politicians (scandal, politician) " +
                        "values (?, ?)",
                scandalId, politician.getId());
    }
    private void savePartyToScandal(
            Party party, long scandalId) {
        jdbc.update(
                "insert into Scandal_Parties (scandal, party) " +
                        "values (?, ?)",
                scandalId, party.getId());
    }





    @Override
    public Iterable<Scandal> findAll() {
        return jdbc.query("select * from Scandal",
                this::mapRowToScandal);
    }
    @Override
    public Scandal findById(String id) {
        return jdbc.queryForObject(
                "select * from Scandal where id = ?",
                this::mapRowToScandal,
                id
        );
    }
//jeb z dzidy- zapierdalamy, napierdalamy


    private Scandal mapRowToScandal(ResultSet rs, int rowNum) throws SQLException {
        return new Scandal(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getTimestamp("createdAt").toLocalDateTime(),
                rs.getTimestamp("updatedAt").toLocalDateTime(),
                rs.getInt("startYear"),
                rs.getInt("endYear"),
                new ArrayList<>(),
                new ArrayList<>(), // associatedPoliticalParties - na razie pusta lista
                rs.getBigDecimal("confirmedEmbezzledAmountOfMoney"),
                rs.getBigDecimal("unconfirmedEmbezzledAmountOfMoney")
        );
    }}
