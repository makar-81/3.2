package io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emakarov on 27.01.2016.
 */

public class Main {
    public static void main(String[] args) {
        // put your code here
        try {
            BufferedReader br;
            BufferedWriter bw;
            String temp;

            //BufferedInputStream fr;
            //OutputStream bw;
            // wr;
            FileReader fr = new FileReader("./test1.txt");
            FileWriter wr = new FileWriter("./test2.txt");

            bw = new BufferedWriter(wr);
            br = new BufferedReader(fr);

            //br = new BufferedReader(new InputStreamReader(System.in));
            //bw = new BufferedWriter(new OutputStreamWriter(System.out));

            Map<String, Integer> store = new HashMap<String, Integer>();
            Map<Integer, String> keys = new HashMap<Integer, String>();

            try {
                int key = 1;
                while ((temp = br.readLine()) != null) {

                    while (!temp.isEmpty()) {

                        String word = "";
                        int pos = temp.indexOf(" ");
                        if (pos > 0) {
                            word = temp.substring(0, pos);
                            temp = temp.substring(pos + 1, temp.length());
                        } else {
                            word = temp.substring(0, temp.length());
                            temp = "";
                        }
                        if (store.get(word) != null) {
                            store.put(word, store.get(word) + 1);
                            if (!keys.containsValue(word)) {
                                keys.put(key, word);
                                key = key + 1;
                            }
                        } else {
                            store.put(word, 1);
                            if (!keys.containsValue(word)) {
                                keys.put(key, word);
                                key = key + 1;
                            }
                        }

                    }

                }
                for (int i = 1; i <= keys.size(); i++) {
                    //System.out.println(keys.get(i).toString() + "\t" + store.get(keys.get(i)));
                    //bw.write(keys.get(i).toString() + "\t" + store.get(keys.get(i))+ "\n");
                    bw.write(keys.get(i).toString() + "\t" + store.get(keys.get(i)) + "\n");
                    bw.flush();
                }

                keys.clear();
                store.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
              catch (IOException e) {
                e.printStackTrace();
            }
    }
}


