package org.example.Tasks;

import java.util.ArrayList;
import java.util.Scanner;

/*

4
push Трек1
push Трек3
pop
push ТрекТрек

*/

public class QueuePlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> playlist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String action = input.split(" ")[0];

            if (action.equals("pop")) {
                System.out.println("воспроизводится " + playlist.removeFirst());
            } else if (action.equals("push")) {
                String music = input.split(" ")[1];
                playlist.add(music);
            }
        }

        for (String music: playlist) {
            System.out.print(music + " ");
        }
    }
}
