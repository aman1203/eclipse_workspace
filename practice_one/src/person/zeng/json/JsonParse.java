package person.zeng.json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParse {
  public static void main(String[] args) {
    BaseResult<User> baseResult = new BaseResult<User>(1, "12", "我的老家", new User("zjie", 30));
    ObjectMapper objMapper = new ObjectMapper();
    try {
      String result = objMapper.writeValueAsString(baseResult);
      System.out.println(result);
      BaseResult<User> baseresult =
          jsonUtils.parseFromJsonToObject(result, new TypeReference<BaseResult<User>>() {});
      System.out.println(baseresult.getDate().getName());
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}


class jsonUtils {
  public static <T> T parseFromJsonToObject(String str, TypeReference<T> t) {
    T result = null;
    ObjectMapper objMapper = new ObjectMapper();
    try {
      result = objMapper.readValue(str, t);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
