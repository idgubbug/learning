package com.futrue;

public class FutureClient {
    /**
     * @Description:
     * @Param: [queryStr]
     * @return: com.futrue.Data
     * @Author: Mr.huang
     * @Date: 2019/5/15 22:38
     **/
    public Data request(final String queryStr) {
        final FurureData furureData = new FurureData();
        new Thread(new Runnable() {

            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                furureData.setRealData(realData);
            }
        }).start();
        return furureData;

    }

}