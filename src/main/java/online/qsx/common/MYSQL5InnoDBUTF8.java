package online.qsx.common;

import org.hibernate.dialect.MySQL5Dialect;

public class MYSQL5InnoDBUTF8 extends MySQL5Dialect{
	@Override
	public String getTableTypeString() {
		// TODO Auto-generated method stub
		return "ENGINE=InnoDB CHARSET=UTF8";
	}
}
