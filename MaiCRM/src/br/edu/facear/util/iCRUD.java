package br.edu.facear.util;

import java.sql.SQLException;
import java.util.List;

public interface iCRUD<T> {
	
	public void Create(T obj) throws SQLException;
	public void Update(T obj) throws SQLException;
	public List<T> Read() throws SQLException;
}
