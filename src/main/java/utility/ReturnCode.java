package utility;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ReturnCode<T> implements Serializable {
  private int code;
  private String msg;
  private T data;

  public ReturnCode(int code,String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ReturnCode(int code,String msg,T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  /**
   * Customized Data
   * @param data
   * @return
   */
  public ReturnCode setData(T data) {
    this.data = data;
    return this;
  }

  /**
   * Customized message
   * @param msg
   * @return
   */
  public ReturnCode setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  //=========================常用响应code ==========================//

  /**
   * 0 为 成功响应
   */
  public static final ReturnCode SUCCESS = new ReturnCode(0, "Success");

  /**
   * 1000系列 入参数据错误相关响应
   */
  public static final ReturnCode ERR_DATA = new ReturnCode(1000, "Data Error");
  public static final ReturnCode ERR_PARAM = new ReturnCode(1100, "Request param Error");

  /**
   * 2000系列 数据库相关错误响应
   */
  public static final ReturnCode ERR_DBFAIL = new ReturnCode(2000, "Database Error");

  /**
   * 3000系列 网络错误响应
   */
  public static final ReturnCode ERR_NETWORK = new ReturnCode(3000, "Network Error");


  /**
   * 4000系列 其他错误响应
   */
  public static final ReturnCode FAIL = new ReturnCode(4000, "Operation Fail");

}
