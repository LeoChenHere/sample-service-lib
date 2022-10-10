package utility;

import java.util.HashMap;

import static utility.ReturnData.ReturnProp.*;

public class ReturnData {

  enum ReturnProp{
    code,
    msg,
    data;
  }

  public static HashMap returnData(ReturnCode rc){
    //- return result
    HashMap hm = new HashMap();
    hm.put(ReturnProp.code, rc.getCode());
    hm.put(ReturnProp.msg, rc.getMsg());
    return hm;
    //-
  }
  public static HashMap returnData(ReturnCode rc, Object data){
    //- return result
    HashMap hm	 = new HashMap();
    hm.put(ReturnProp.code, rc.getCode());
    hm.put(ReturnProp.msg, rc.getMsg());
//    System.out.print(data.getClass().getSimpleName());
    if("String".equals(data.getClass().getSimpleName())){
      hm.put(ReturnProp.data, data);
    }else{
      hm.put(ReturnProp.data, data);
    }
    return hm;
    //-
  }
}
