package Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTextPerRole {
    public static void main(String[] args) {
        String [] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(print(roles, textLines));
    }

    private static String print(String[] roles, String[] textLines) {
        Map<String, List<String>> dict = new HashMap<>();

        for (String role : roles) {
            if (!dict.containsKey(role)) {
                dict.put(role, new ArrayList<>());
            }
        }

        for (int i = 0; i < textLines.length; i++) {
            int indexSep = textLines[i].indexOf(":");

            String key = textLines[i].substring(0, indexSep);
            String value = String.format("%d) %s\n", i + 1, textLines[i].substring(indexSep + 2));

            dict.get(key).add(value);
        }

        StringBuilder result = new StringBuilder();
        for (String role : roles) {
            result.append(String.format("%s:\n", role));
            Object[] array = dict.get(role).toArray();

            for (Object line : array) {
                result.append(line);
            }

            result.append("\n");
        }

        return result.toString();
    }
}
