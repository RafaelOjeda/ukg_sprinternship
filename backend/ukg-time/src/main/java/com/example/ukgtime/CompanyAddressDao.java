package com.example.ukgtime;

import com.example.ukgtime.Company.CompanyAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyAddressDao implements CorporateEventDao<CompanyAddress>{
    private static Logger logger = LoggerFactory.getLogger(CompanyAddressDao.class);
    private JdbcTemplate jdbcTemplate;
    private RowMapper<CompanyAddress> rowMapper = (rs, rowNum) -> {
        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setCompanyId(rs.getLong("company_id"));
        companyAddress.setCompanyOfficeId(rs.getLong("company_office_id"));
        companyAddress.setStreet(rs.getString("street"));
        companyAddress.setZip(rs.getString("zip"));
        companyAddress.setCountry(rs.getString("country"));

        return companyAddress;
    };

    @Autowired
    public CompanyAddressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(CompanyAddress companyAddress) {
        String sql = "INSERT INTO company_address (company_id, company_office_id, street, zip, " +
                "country) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, companyAddress.getCompanyId(), companyAddress.getCompanyOfficeId(),
                companyAddress.getStreet(), companyAddress.getZip(), companyAddress.getCountry());
        return true;
    }

    @Override
    public boolean find(long id) {
        String sql = "SELECT COUNT(*) FROM company_address WHERE company_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return (count >= 1);
    }

    @Override
    public List<CompanyAddress> list() {
        return List.of();
    }

    @Override
    public Optional<CompanyAddress> get(long id) {
        return Optional.empty();
    }

    @Override
    public void update(CompanyAddress companyAddress, long id) {

    }

    @Override
    public void delete(long id) {

    }
}
