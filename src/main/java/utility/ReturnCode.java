package utility;

import lombok.Getter;

@Getter
public enum ReturnCode implements IReturnCode{
  OK(0, "Success"),
  ERR_DATA(1000, "Data error"),
  ERR_DBFAIL(2000, "Database error"),
  ERR_NETWORK(3000, "Network error"),
  ERR_INTERNAL(4000, "Database error");

  private int code;
  private String msg;

  ReturnCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static void main(String[] args){
    for( ReturnCode rc : ReturnCode.values() ){
      System.out.println(rc);
    }
  }
}
