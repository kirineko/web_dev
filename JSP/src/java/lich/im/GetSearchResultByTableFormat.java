package lich.im;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class GetSearchResultByTableFormat {
    public GetSearchResultByTableFormat() {
        conn_init();
    }
    Connection conn;
    Statement st;
    int currentPage; //当前页号
    int pageSize; //每页显示记录条数
    int totalPage; //总共页数
    int previousPage; //前一页页号
    int nextPage; //下一页页号
    int columnCount; //总共列数
    int totalRecord; //总记录数
    String tableTitle; //大标题，这个的下面才是显示的内容
    String editUrl; //编辑页面的URL
    String delUrl; //删除页面的URL
    String viewUrl; //查看指定记录URL
    String currentPageUrl;//当前页面的url地址
    boolean verify = false; //是否当前记录验证
    String verifyURL; //记录的验证地址
    boolean sort;//是否需要动态排序
    int sortType;//排序类型，一为升序，2为降序
    String desc="▼";
    String asc="▲";
    String sortColumn;//排序的字段
    boolean search;//是否显示查询功能
    String searchType;
    String searchCondition;
    /******************************初使化数据库链接******************************/
    private void conn_init() {
        setConnection();
        setStatement();
    }

    private void setConnection() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String strurl;
            strurl = 
                    "jdbc:jtds:sqlserver://127.0.0.1:1122/happyolder.mdf";
            conn = DriverManager.getConnection(strurl,"sa","as798360687");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStatement() {
        try {
            st = 
 conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*****************************初使化数据库链接OK*****************************/

    /**
     * 
     * @param sql 执行的SQL语句
     * @param CurrentPage 当前页
     * @param PageSize 每页显示的记录数
     * @return 执行的结果到StringBuffer中
     */
    public StringBuffer getResult_withTableFormat(String sql, int CurrentPage, 
                                                  int PageSize, 
                                                  boolean withEdit) {
        int rowNum = 0; //总行数
        int TotalPage = 0; //总页数
        int beginRow = 0; //起始记录
        int endRow = 0; //结束记录
        StringBuffer resultRows = new StringBuffer(""); //结果集
        this.pageSize = PageSize; //每页大小
        try {            
            rowNum = getTotalResultSetNum(sql); //取得总记录数
            this.totalRecord = rowNum; //总记录数
            //确定当前页
            if (rowNum % PageSize == 0) {
                TotalPage = rowNum / PageSize;
            } else
                TotalPage = rowNum / PageSize + 1;
            if (CurrentPage >= TotalPage) {
                CurrentPage = TotalPage;
                nextPage = CurrentPage;
                nextPage = CurrentPage + 1; //得到下一页页号
            } else {
                nextPage = CurrentPage + 1; //得到下一页页号
            }

            if (CurrentPage <= 1) {
                CurrentPage = 1;
                previousPage = CurrentPage; //得到前一页页号
            } else {
                previousPage = CurrentPage - 1; //得到前一页页号
            }
            this.currentPage = CurrentPage; //设置当前页
            this.totalPage = TotalPage; //设置总页数
            beginRow = (CurrentPage - 1) * PageSize + 1; //开始记录
            endRow = beginRow + PageSize; //结束记录
            resultRows = 
                    getExecuteResult_withTableFormat(sql, beginRow, endRow, 
                                                     withEdit);
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return resultRows;
    }

    /**
     * 
     * @param sql 要执行的SQL语句
     * @param startPos 记录的开始点，即从得到结果的第几条记录开始返回
     * @param endPos 返回记录的结束点，即最后一条记录
     * @param withEdit 是否加上编辑链接
     * @return 根据SQL语句生成的放在BufferString，并返回
     */
    private StringBuffer getExecuteResult_withTableFormat(String sql, 
                                                         int startPos, 
                                                         int endPos, 
                                                         boolean withEdit) {
        ResultSet rs;
        ResultSetMetaData rsmd; //取得元数据
        int ColumnCount; //返回结果有多少列
        StringBuffer resultStr = new StringBuffer("");
        if(isSearch()) {
            resultStr.append(generateSearchForm(sql));
        }
        resultStr.append("<table border=1>");
        try {
            rs = st.executeQuery(sql);
            rsmd = rs.getMetaData();
            ColumnCount = rsmd.getColumnCount();
            this.columnCount = ColumnCount;
            resultStr.append("<tr>");
            resultStr.append("<td colspan=" + (columnCount + 2) + " align=center>");
            resultStr.append("<font size=6>" + getTableTitle() + "</font>");
            resultStr.append("</td>");
            resultStr.append("</tr>");
            //System.out.println("ColumnCount:" + ColumnCount);
            //System.exit(0);
            //取得列名，列名的顺序下标是从1开始的
            resultStr.append("<tr bgcolor=AF723C>");
            for (int j = 1; j <= ColumnCount; j++) {
                String columnName=rsmd.getColumnName(j);
                String currentPageUrlWithoutParameteor=getCurrentPageURLWithoutParameteor(getCurrentPageUrl());                
                if(isSort()) {//要排序吗
                    if(getSortType()==1) {//这次的排序是升序
                        if(columnName.equals(getSortColumn()))
                            resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=asc')>");
                        else
                            resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=desc')>");
                     }
                    if(getSortType()==2 || getSortType()==0) {//这次的排序是降序
                        resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=desc')>");
                    }                    
                }
                else {
                    resultStr.append("<td align=left>");
                }                
                resultStr.append("&nbsp;<font color=white><b>");
                //这个方法，可以将英文字段替换为中文，这个函数自已去完成了
                resultStr.append(replaceEnglishHeadWithChinese(rsmd.getColumnName(j)));
                //如果是有排序的，并且是当前排序字段，那么就增加图案
                if(getSortType()!=0 && columnName.equals(getSortColumn()))
                {
                    if(getSortType()==1) {//升序
                        resultStr.append("/"+desc);
                    }
                    if(getSortType()==2) {//降序
                        resultStr.append("/"+asc);
                    }
                }
                resultStr.append("</b></font></td>");
            }
            resultStr.append("<td>");
            resultStr.append("</td>");
            if (withEdit == true) {
                resultStr.append("<td>");
                resultStr.append("<font color=white><b>操  作</b></font>");
                resultStr.append("</td>");
            }
            resultStr.append("</tr>");
            int currentRecordNum = (currentPage - 1) * 20 + 1;
            if (rs.next()) {
                rs.absolute(startPos); //记录绝对定位
                for (int i = 0; i < (endPos - startPos); i++) {
                    resultStr.append("<tr>");
                    int componentID = 0; //这个范指所有的表中的ID字段
                    for (int j = 1; j <= ColumnCount; j++) {
                        if (j == 1) {
                            {
                                resultStr.append("<td align=left>&nbsp;");
                                //resultStr.append(rs.getInt(j));
                                resultStr.append(currentRecordNum++); //不用数据库的ID，自已经生成ID
                                resultStr.append("</td>");
                                componentID = rs.getInt(j);
                            }
                        } else {
                            resultStr.append("<td align=left>&nbsp;");
                            resultStr.append(rs.getString(j));
                            resultStr.append("</td>");
                        }
                    }
                    resultStr.append("<td>");
                    resultStr.append("<a href=" + getViewUrl() + "?id=" + 
                                     componentID + 
                                     " target=_blank><font color=green><nobr>查看</nobr></font></a>");
                    resultStr.append("</td>");
                    if (withEdit == true) {
                        resultStr.append("<td>");
                        resultStr.append("<nobr>");

                        resultStr.append("<a href=" + getEditUrl() + "?id=" + 
                                         componentID + 
                                         "><font color=blue>编辑</font></a>");
                        resultStr.append("&nbsp;&nbsp;");

                        resultStr.append("<a href=# onclick=delSure('" + 
                                         getDelUrl() + "id=" + componentID + 
                                         "')><font color=red>删除</font></a>");
                        if (isVerify() == true) {
                            resultStr.append("&nbsp;&nbsp;");
                            resultStr.append("<a href=# onclick=passSure('" + 
                                             getVerifyURL() + "?id=" + 
                                             componentID + 
                                             "')><font color=red>审核</font></a>");
                        }
                        resultStr.append("</nobr>");
                        resultStr.append("</td>");
                    }
                    resultStr.append("</tr>");
                    rs.next();
                    if (rs.isAfterLast()) {
                        break;
                    }
                }
            }
            resultStr.append("<tr>");
            resultStr.append("<td colspan=" + (ColumnCount + 2) + 
                             " align=center>");
            resultStr.append(setTurnPageString(getCurrentPageUrl()));
            resultStr.append("</td>");
            resultStr.append("</tr>");
            resultStr.append("</table>");
            resultStr.append(getJSFunction());                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
    /**
     * 这个函数需要自己完成，因为情况不同
     * @param eColumnName 英文列名
     * @return 替换后的中文列名
     */
    private String replaceEnglishHeadWithChinese(String eColumnName) {
        String cColumnName="";
		if (eColumnName == "ID")
		{
			cColumnName = "序号";
		}
		if (eColumnName == "Name")
		{
			cColumnName = "姓名";
		}
		if (eColumnName == "Sex")
		{
			cColumnName = "性别";
		}
		if (eColumnName == "Age")
		{
			cColumnName = "出生年月";
		}
		if (eColumnName == "Phone")
		{
			cColumnName = "联系电话";
		}
		if (eColumnName == "Address")
		{
			cColumnName = "住址";
		}
		if (eColumnName == "Marry")
		{
			cColumnName = "婚姻状况";
		}
		if (eColumnName == "Hobby")
		{
			cColumnName = "兴趣爱好";
		}
		if (eColumnName == "Shop")
		{
			cColumnName = "习惯的购物场所";
		}
		if (eColumnName == "Servers")
		{
			cColumnName = "需要的服务";
		}
		if (eColumnName == "Income")
		{
			cColumnName = "收入";
		}
		if (eColumnName == "Healthy")
		{
			cColumnName = "健康状况";
		}
        return cColumnName;
    }
    /**
     * 
     * @param sql sql语句
     * @return 根据sql语句生成的查询form
     */
    private StringBuffer generateSearchForm(String sql) {
        StringBuffer str=new StringBuffer("");
        String searchType=getSearchType();
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int ColumnCount = rsmd.getColumnCount();
            String searchCondition=getSearchCondition();
            if(searchCondition==null)
                searchCondition="";
            str.append("<form method=get action="+getCurrentPageURLWithoutParameteor(getCurrentPageUrl())+">");
            str.append("输入条件：<input type=text name=searchCondition size=10 value="+searchCondition+"> ");
            str.append("选择类型：<select name=searchType>");
            str.append("<option value=null>请选择类型</option>");
            for(int i=1;i<=ColumnCount;i++) {                
                String cName=replaceEnglishHeadWithChinese(rsmd.getColumnName(i));
                if(searchType!=null && searchType.equals(cName))
                    str.append("<option value="+cName+" selected>"+cName+"</option>");
                else
                    str.append("<option value="+cName+">"+cName+"</option>");
            }
            str.append("</select>");
            str.append("<input type=submit value=查询>");
            str.append("</form>");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    //将JavaScript函数动态输出:函数SortByThis(url)
    private StringBuffer getJSFunction() {
        StringBuffer str=new StringBuffer("");        
        str.append("<script language=JavaScript1.2 type=text/javascript>");
        str.append("function SortByThis(url){window.location=url;}");
        str.append("</script>");
        return str;
    }
    /**
     * 
     * @param httpUrl URL地址，可以是带参数的
     * @return 生成的首页、上页、下页、末页等字符串
     */
    private String setTurnPageString(String httpUrl) {
        String turnPageStrng = "";
        String divideS = "&nbsp;&nbsp;&nbsp;&nbsp;";
        turnPageStrng = "总记录数：" + totalRecord;
        turnPageStrng = turnPageStrng + divideS + "总页数：" + totalPage;
        turnPageStrng = turnPageStrng + divideS + "每页记录数：" + pageSize;
        if (httpUrl.indexOf("?") > 0) //如果请求地址是有条件的，就加&连接其它的条件
            httpUrl += "&page=";
        else
            httpUrl += "?page=";
        String hS = "<a href=" + httpUrl + "1>首页</a>" + divideS;
        String pS = "<a href=" + httpUrl + previousPage + ">前页</a>" + divideS;
        String cS = "当前第" + currentPage + "页" + divideS;
        String tS = "转到第<input type=text size=2 id=goToPage";
        tS += " onKeyDown=\"if(window.event.keyCode==13) goToPage('";
        tS += httpUrl + "');\" value=" + nextPage + ">页";
        tS += "<input type=button name=g value=Go ";
        tS += "onclick=\"goToPage('" + httpUrl + "');\">" + divideS;
        String nS = "<a href=" + httpUrl + nextPage + ">下页</a>" + divideS;
        String lS = "<a href=" + httpUrl + totalPage + ">末页</a>";
        turnPageStrng = turnPageStrng + divideS + hS + pS + cS + tS + nS + lS;
        return turnPageStrng;
    }

    /**
     * 取得总记录数
     * @return
     */
    private int getTotalResultSetNum(String sql) {
        int num = 0;
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                rs.last(); //移到最后一条
                num = rs.getRow(); //取得总记录数
                rs.first(); //再移到第一条记录
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    /**
     * 
     * @param url 带参数或者是不带参数的当前页面的url
     * @return 去掉参数的当前页面的url
     */
    private String getCurrentPageURLWithoutParameteor(String url) {
        if(url.indexOf("?")>0)
            return url.split("\\?")[0];
        else
            return url;
    }
    /**************************针对变量的set、get方法**************************/
    public
    //设置表头
    void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }
    //取得表头

    private String getTableTitle() {
        return tableTitle;
    }
    //设置查看对应记录的URL

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
    //取得查看对应记录的URL

    private String getViewUrl() {
        return viewUrl;
    }
    //设置编辑指定记录的URL

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }
    //取得编辑指定记录的URL

    private String getEditUrl() {
        return editUrl;
    }
    //设置删除指定记录的URL

    public void setDelUrl(String delUrl) {
        this.delUrl = delUrl;
    }
    //取得删除指定记录的URL

    private String getDelUrl() {
        return delUrl;
    }
    //设置是否通过验证

    public void setVerify(boolean verify) {
        this.verify = verify;
    }
    //获得是否通过验证

    private boolean isVerify() {
        return verify;
    }
    //设置通过验证指定记录的URL

    public void setVerifyURL(String verifyURL) {
        this.verifyURL = verifyURL;
    }
    //取得验证指定记录的URL

    private String getVerifyURL() {
        return verifyURL;
    }
    //设置当前页的URL

    public void setCurrentPageUrl(String currentPageUrl) {
        this.currentPageUrl = currentPageUrl;
    }
    //取得当前页的URL

    private String getCurrentPageUrl() {
        return currentPageUrl;
    }    

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    private boolean isSort() {
        return sort;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    private int getSortType() {
        return sortType;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    private String getSortColumn() {
        return sortColumn;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    private boolean isSearch() {
        return search;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    private String getSearchType() {
        return searchType;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    private String getSearchCondition() {
        return searchCondition;
    }
    /**************************针对变量的set、get方法OK**************************/
}