package itis.grp403.TimurSibgatullin.HW;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JSONMapper {

    public String toJson(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Получаем все поля класса
        Field[] fields = obj.getClass().getDeclaredFields();

        StringBuilder sb = new StringBuilder("{");
        for (Field f : fields) {
            // "fieldName":
            sb.append("\"").append(f.getName()).append("\":");
            /*
                f.setAccessible(true);
                f.get(obj)
            */
            // ищем геттер для поля, для получения значения
            Method getter = obj.getClass().getMethod("get" +
                    f.getName().toUpperCase().charAt(0) +
                    f.getName().substring(1));

            // значение получаем вызовом геттера getter.invoke(obj)
            if (f.getType().equals(String.class)) {
                sb.append("\"").append(getter.invoke(obj)).append("\"");
            } else if (f.getType().getSuperclass().equals(Number.class)) {
                sb.append(getter.invoke(obj).toString());
            } else if (f.getType().equals(Date.class)) {
                Annotation dateAnnotation = f.getAnnotation(DateFormat.class);
                if (dateAnnotation != null) {
                    String dateFormat = ((DateFormat)dateAnnotation).value();
                    Date d = (Date) getter.invoke(obj);
                    sb.append("\"").append(new SimpleDateFormat(dateFormat).format(d)).append("\"");
                } else {
                    sb.append(getter.invoke(obj).toString());
                }
            } else {
                sb.append("\"").append(getter.invoke(obj).toString()).append("\"");
            }
            sb.append(',');
        }
        int pos = sb.length();
        sb.replace(pos - 1, pos, "}");
        return sb.toString();
    }

    public Object parseJson(String json, Class clazz) throws Exception {
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Map<String, String> map = parseJsonToMap(json);
        for (Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) continue;

            String value = map.get(name);
            field.setAccessible(true);

            if (field.getType().equals(String.class)) {
                field.set(obj, value);
            } else if (field.getType().equals(Integer.class)) {
                field.set(obj, Integer.valueOf(value));
            } else if (field.getType().equals(Double.class)) {
                field.set(obj, Double.valueOf(value));
            } else if (field.getType().equals(Date.class)) {
                DateFormat df = field.getAnnotation(DateFormat.class);
                String format = (df != null) ? df.value() : "yyyy-MM-dd";
                Date date = new SimpleDateFormat(format).parse(value);
                field.set(obj, date);
            }
        }
        return obj;
    }

    private Map<String, String> parseJsonToMap(String json) {
        Map<String, String> map = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // Remove { and }
        String[] entries = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by commas not in quotes

        for (String entry : entries) {
            String[] kv = entry.split(":", 2);
            if (kv.length != 2) continue;
            String key = kv[0].trim().replaceAll("^\"|\"$", "");
            String value = kv[1].trim().replaceAll("^\"|\"$", "");
            map.put(key, value);
        }
        return map;
    }
}
