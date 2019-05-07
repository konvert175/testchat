package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



import javax.sql.DataSource;
import java.util.List;

//@Repository
public class ChatUserDAOImpl //extends JdbcDaoSupport
{
   /* private DataSource dataSource;

    @Autowired
    public ChatUserDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
*/
    public void /*List<String>*/ getUserlogins() {
/*
        String sql = "select User_login from UserTable ";

        // queryForList(String sql, Class<T> elementType)
        List<String> list ;//= this.getJdbcTemplate().queryForList(sql, String.class);

        return list;*/
    }
}
