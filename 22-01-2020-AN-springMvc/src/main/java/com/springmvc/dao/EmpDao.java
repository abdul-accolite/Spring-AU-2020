package com.springmvc.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Emp;  
  
public class EmpDao {  
JdbcTemplate jdbc;  
  
public void setTemplate(JdbcTemplate template) {  
    this.jdbc = template;  
}  
public int save(Emp emp){  
    String sql="insert into Employee(name,salary,designation) values('"+emp.getName()+"',"+emp.getSalary()+"')";  
    return jdbc.update(sql);  
}  
public int update(Emp emp){  
    String sql="update Employee set name='"+emp.getName()+"', salary="+emp.getSalary()+"' where id="+emp.getId()+"";  
    return jdbc.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Employee where id="+id+"";  
    return jdbc.update(sql);  
}  
public Emp getEmpById(int id){  
    String sql="select * from Employee where id=?";  
    return jdbc.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(){  
    List<Emp> list = jdbc.query("select * from Employee",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp emp=new Emp();  
            emp.setId(rs.getInt(1));  
            emp.setName(rs.getString(2));  
            emp.setSalary(rs.getFloat(3));    
            return emp;  
        }  
    }); 
    return list;
}  
}  