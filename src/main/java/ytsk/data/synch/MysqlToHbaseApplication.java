package ytsk.data.synch;

import ytsk.data.synch.offline.OffLineSynch;
import ytsk.data.synch.online.OnlineSynch;

/**
 * 程序入口
 */
public class MysqlToHbaseApplication {

    public static void main(String[] args) {
        //离线数据同步
        OffLineSynch offLineSynch = new OffLineSynch();
        offLineSynch.synchToHbase();
//        offLineSynch.synchFromHbase();
//        offLineSynch.selectByVin();

        //实时数据同步

       OnlineSynch onlineSynch = new OnlineSynch();
        onlineSynch.synchToHbase();
    }

}
