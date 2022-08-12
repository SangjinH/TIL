package chapter1.item13_clone;


public final class PhoneNumber implements Cloneable {

  public static void main(String[] args) {
    PhoneNumber phoneNumber = new PhoneNumber(123, 456, 7890);
    phoneNumber.clone();
  }

  // 가변이 가능한 코드로 바꾸고 싶다면 implements Cloneable.
  @Override
  public PhoneNumber clone() {
    try {
      return (PhoneNumber) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(); // 일어날 수 없는 일이다.
    }
  }

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "지역코드");
    this.prefix = rangeCheck(prefix, 999, "프리픽스");
    this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max)
      throw new IllegalArgumentException(arg + ": " + val);
    return (short) val;
  }
}



