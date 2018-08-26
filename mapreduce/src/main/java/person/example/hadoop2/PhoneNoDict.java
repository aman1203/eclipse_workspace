package person.example.hadoop2;

public class PhoneNoDict {
  public static int region(String str) {
    switch(Integer.parseInt(str)) {
      case 135:return 0;
      case 136:return 1;
      case 137:return 2;
      case 138:return 3;
      case 139:return 4;
      default:return 5;
    }
  } 
}
