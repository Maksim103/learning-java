package org.example.Tasks;

/*
1.Мама мыла-мыла-мыла раму!

2.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
*/

/*
1.
мыла
мама
раму

2.
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class FrequencyWords {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);

        Map<String, Long> map = Arrays.stream(bufferedReader.readLine().split("[^a-zA-Zа-яА-Я0-9']+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        map.entrySet().stream()
                .sorted(Comparator
                        .comparing(Map.Entry<String, Long>::getValue, Collections.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}



