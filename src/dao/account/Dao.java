package dao.account;

import entity.Account;

public class Dao extends DbUtil {
	
	/**
	 * query account by 'user'
	 * @param user
	 * @return
	 */
	public Account queryByUser(String user){
		String sql = "select * from account where user = ?";
		return super.excuteQuery(sql , user);
	}
}
