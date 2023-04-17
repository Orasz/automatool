
package com.automatool.poc;

import org.springframework.stereotype.Service;

@Service
class BusinessService {{
    
public {OutputModel} doSomeBusinessLogic({InputModel} inputModel){{
    //implement custom logic here
    return Randomizer.randomize({{OutputModel}}.class);
}}

public static class Randomizer {{
    private static final Random random = new Random();

    public static <T> T randomize(Class<T> clazz) throws Exception {{
      T instance = clazz.getDeclaredConstructor().newInstance();
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {{
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
        if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {{
          field.set(instance, random.nextInt());
        }} else if (fieldType.equals(String.class)) {{
          field.set(instance, getRandomString());
        }} else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {{
          field.set(instance, random.nextBoolean());
        }} else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {{
          field.set(instance, random.nextLong());
        }} else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {{
          field.set(instance, random.nextLong());
        }} else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {{
          field.set(instance, random.nextLong());
        }} else if (fieldType.equals(List.class)) {{
          ParameterizedType listType = (ParameterizedType) field.getGenericType();
          Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
          List<Object> list = new ArrayList<>();
          for (int i = 0; i < 5; i++) {{
            list.add(randomize(listClass));
          }}
          field.set(instance, list);
        }} else if (fieldType.equals(Map.class)) {{
          ParameterizedType mapType = (ParameterizedType) field.getGenericType();
          Class<?> keyClass = (Class<?>) mapType.getActualTypeArguments()[0];
          Class<?> valueClass = (Class<?>) mapType.getActualTypeArguments()[1];
          Map<Object, Object> map = new HashMap<>();
          for (int i = 0; i < 5; i++) {{
            map.put(randomize(keyClass), randomize(valueClass));
          }}
          field.set(instance, map);
        }} else {{
          field.set(instance, randomize(fieldType));
        }}
      }}
      return instance;
    }}
    private static String getRandomString() {{
      int length = random.nextInt(10) + 1;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < length; i++) {{
        char c = (char) (random.nextInt(26) + 'a');
        sb.append(c);
      }}
      return sb.toString();
    }}
  }}
    
}}
