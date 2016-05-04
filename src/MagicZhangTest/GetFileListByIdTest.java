package MagicZhangTest;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;

public class GetFileListByIdTest {

	public static void main(String[] args) {
		FileManageDao dao = new FileManageDaoImpl();
		
		dao.getFileListById("1");
	}
	
	
}
