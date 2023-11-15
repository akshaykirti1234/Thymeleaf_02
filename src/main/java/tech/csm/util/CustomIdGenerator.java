package tech.csm.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT MAX(employee_id) FROM employee");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String lastEmpId = rs.getString(1);
				String newEmpId = generateNextEmpId(lastEmpId);
				return newEmpId;
			}
		} catch (SQLException e) {
			throw new HibernateException("Unable to generate employee ID", e);
		}
		return null;
	}

	private String generateNextEmpId(String lastEmpId) {
		if (lastEmpId == null) {
			return "01-3000";// Assuming a starting point for the employee ID
		}

		String[] parts = lastEmpId.split("-");
		Integer prefix = Integer.parseInt(parts[0]);
		Integer number = Integer.parseInt(parts[1]);

		if (number == 9999) {
			// If the number reaches the maximum, increment the prefix and reset the number.
			prefix++;
			number = 1;
		} else {
			// Otherwise, just increment the number.
			number++;
		}
		return String.format("%02d-%04d", prefix, number);
	}
}
