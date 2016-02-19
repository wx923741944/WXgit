package com.qianfeng.liu.itrip.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxiong
 *
 * @date 2011/1/1 0001.
 */
public class Trip {


    /**
     * success : true
     * result : {"banners":[{"img":"http://pic2.itrip.com/p/20160202163235-836.jpg","type":1,"url":"http://m.itrip.com/magazine/huodong/goods/index.html?channel=3000&vc=-1","title":""},{"img":"http://pic2.itrip.com/p/20160111144633-883.jpg","type":1,"url":"http://m.itrip.com/magazine/activity/new_year/?channel=3000&vc=-1","title":""},{"img":"http://pic2.itrip.com/p/20160111112331-103.jpg","type":2,"url":"2271","title":""},{"img":"http://pic2.itrip.com/p/20160126172555-598.jpg","type":1,"url":"http://m.itrip.com/magazine/share/wap_index.html?channel=3000&vc=-1","title":""},{"img":"http://pic2.itrip.com/p/20160127104907-241.jpg","type":2,"url":"16270","title":""}],"sycx":[],"sjzx":[{"img":"http://pic2.itrip.com/p/20160202153955-460.jpg","type":1,"url":"http://m.itrip.com/magazine/huodong/goods/index.html?channel=3000&vc=-1","title":""},{"img":"http://pic2.itrip.com/p/20151119132427-52.jpg","type":2,"url":"4292","title":""},{"img":"http://pic2.itrip.com/p/20160128181839-492.jpg","type":2,"url":"4680","title":""},{"img":"http://pic2.itrip.com/p/20160106100332-421.jpg","type":2,"url":"15131","title":""}],"kjdh":[{"img":"http://pic2.itrip.com/p/20160125161017-22.png","type":3,"url":"{\"type\":100}","title":"吃喝玩乐"},{"img":"http://pic2.itrip.com/p/20160125161036-553.png","type":3,"url":"{\"type\":500}","title":"懒人套餐"},{"img":"http://pic2.itrip.com/p/20160125161114-227.png","type":3,"url":"{\"type\":200}","title":"境外跟团"}]}
     */

    private boolean success;
    private ResultEntity result;

    public static Trip objectFromData(String str) {

        return new Gson().fromJson(str, Trip.class);
    }

    public static List<Trip> arrayTripFromData(String str) {

        Type listType = new TypeToken<ArrayList<Trip>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity {
        /**
         * img : http://pic2.itrip.com/p/20160202163235-836.jpg
         * type : 1
         * url : http://m.itrip.com/magazine/huodong/goods/index.html?channel=3000&vc=-1
         * title :
         */

        private List<BannersEntity> banners;
        private List<?> sycx;
        /**
         * img : http://pic2.itrip.com/p/20160202153955-460.jpg
         * type : 1
         * url : http://m.itrip.com/magazine/huodong/goods/index.html?channel=3000&vc=-1
         * title :
         */

        private List<SjzxEntity> sjzx;
        /**
         * img : http://pic2.itrip.com/p/20160125161017-22.png
         * type : 3
         * url : {"type":100}
         * title : 吃喝玩乐
         */

        private List<KjdhEntity> kjdh;

        public static ResultEntity objectFromData(String str) {

            return new Gson().fromJson(str, ResultEntity.class);
        }

        public static List<ResultEntity> arrayResultEntityFromData(String str) {

            Type listType = new TypeToken<ArrayList<ResultEntity>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public void setBanners(List<BannersEntity> banners) {
            this.banners = banners;
        }

        public void setSycx(List<?> sycx) {
            this.sycx = sycx;
        }

        public void setSjzx(List<SjzxEntity> sjzx) {
            this.sjzx = sjzx;
        }

        public void setKjdh(List<KjdhEntity> kjdh) {
            this.kjdh = kjdh;
        }

        public List<BannersEntity> getBanners() {
            return banners;
        }

        public List<?> getSycx() {
            return sycx;
        }

        public List<SjzxEntity> getSjzx() {
            return sjzx;
        }

        public List<KjdhEntity> getKjdh() {
            return kjdh;
        }

        public static class BannersEntity {
            private String img;
            private int type;
            private String url;
            private String title;

            public static BannersEntity objectFromData(String str) {

                return new Gson().fromJson(str, BannersEntity.class);
            }

            public static List<BannersEntity> arrayBannersEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<BannersEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public int getType() {
                return type;
            }

            public String getUrl() {
                return url;
            }

            public String getTitle() {
                return title;
            }
        }

        public static class SjzxEntity {
            private String img;
            private int type;
            private String url;
            private String title;

            public static SjzxEntity objectFromData(String str) {

                return new Gson().fromJson(str, SjzxEntity.class);
            }

            public static List<SjzxEntity> arraySjzxEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<SjzxEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public int getType() {
                return type;
            }

            public String getUrl() {
                return url;
            }

            public String getTitle() {
                return title;
            }
        }

        public static class KjdhEntity {
            private String img;
            private int type;
            private String url;
            private String title;

            public static KjdhEntity objectFromData(String str) {

                return new Gson().fromJson(str, KjdhEntity.class);
            }

            public static List<KjdhEntity> arrayKjdhEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<KjdhEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public int getType() {
                return type;
            }

            public String getUrl() {
                return url;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
