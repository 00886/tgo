package cn.tgo.util;

import javax.servlet.http.HttpServletRequest;


public class BaseController {
        /**
         * 起始记录数
         */
        private int pageNo = 0;

        /**
         * 总记录数
         */
        private long total;

        /**
         * 每页显示记录数
         */
        public final static  int PAGE_NUM_BIG = 10;


        /**
         * 初始化分页信息
         */
        public void initPage(HttpServletRequest request){
            String page_str = request.getParameter("pager.offset");
            if(page_str!=null && !page_str.equals("")){
                pageNo = Integer.parseInt(page_str);
            }
        }


        public int getPageNo() {
            return pageNo;
        }


        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }


        public long getTotal() {
            return total;
        }


        public void setTotal(long total) {
            this.total = total;
        }


        public static int getPageNumBig() {
            return PAGE_NUM_BIG;
        }
}


