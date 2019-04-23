package importTemplate;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.google.common.collect.Lists;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-28 19:27
 */
public class OneTwoThree {

      private final static String TITLE_NAME = "北京市卫生计生热线（12320）服务中心";

      public static void main(String[] args) throws Exception {

        InputStream inputStream = new FileInputStream("c:/temp/12320.xls");
        List<Object> excelDataList = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        //第一行为标题,判断标题是否一致,总数是size - 1
        if (excelDataList.size() > 1) {
          //判断标题是否一致,不是则导入模板有误
          List<String> titleLine = (List<String>)excelDataList.get(0);
          String allTitleName = titleLine.get(0);

          if (titleLine.size() != 10 || !TITLE_NAME.equals(allTitleName)) {
            //TODO 模板不对,抛异常
          }


          List<String> list = Lists.newArrayList();
          //单个案件,不需要遍历
          List<String> line = (List<String>)excelDataList.get(0);
          String originalCaseNo = ((List<String>)excelDataList.get(3)).get(4); //工单编号
          String disputeType = "医疗纠纷";
          String disputeTypeCode = "MEDICAL_TANGLE";
          String disputeContent = ((List<String>)excelDataList.get(13)).get(1); //工单内容
          String originalOrgName = ""; // (原处理机构)
          String orgName = "";
          String orgAreaCode = "";

          //TODO 判断转为 编码?
          String sex = ((List<String>)excelDataList.get(6)).get(3); //性别
          String applyUserName = ((List<String>)excelDataList.get(6)).get(1); //姓名
          String phone = ((List<String>)excelDataList.get(7)).get(1); //来电号码

          //TODO 省市区 固定为石景山区
          String provCode;
          String cityCode;
          String areaCode;
          String provName;
          String cityName;
          String areaName;
          String streetCode;
          String streetName;
          String address = "";

          list.add(applyUserName);
        }

        inputStream.close();
      }
}
