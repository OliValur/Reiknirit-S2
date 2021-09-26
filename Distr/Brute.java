package Distr;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Brute {
    public static void BruteChecker(s2.Point[] points) {
        double slope1 = 0;
        double slope2 = 1;
        double slope3 = 2;
        double slope4 = 3;
        Arrays.sort(points);
        int n = points.length;
        int pointArray[];
        pointArray = new int[4];
        int count = 0;
        Map<String, String> dictionary = new HashMap<String, String>();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    slope2 = points[i].slopeTo(points[k]);
                    if (1 == 1) {
                        for (int j = 0; j < n; j++) {
                            if (k != i && k != j) {
                                slope3 = points[i].slopeTo(points[j]);
                                if (slope3 == slope2) {
                                    for (int x = 0; x < n; x++) {
                                        if (x != i && x != j && x != k) {
                                            slope4 = points[i].slopeTo(points[x]);
                                            if (slope4 == slope2) {
//                                                String pointString = points[i] + " ->" + points[j] + " ->" + points[k] + " ->" + points[x];
                                                pointArray[0] = i;
                                                pointArray[1] = j;
                                                pointArray[2] = k;
                                                pointArray[3] = x;
                                                Arrays.sort(pointArray);
                                                String pointString2 = "";
                                                for (int m = 0; m < 4; m++) {
                                                    if (m != 0) {
                                                        pointString2 += " -> " + points[pointArray[m]];
                                                    } else {
                                                        pointString2 += points[pointArray[m]];
                                                    }
                                                }
                                                if (!dictionary.containsKey(pointString2)) {
                                                    dictionary.put(pointString2, "a");
                                                    System.out.println(pointString2);
                                                }
                                                dictionary.put(pointString2, "a");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(dictionary);
    }


    public static void main(String[] args) {
        In in = new In("input_from_S2_main_2");
        Out out = new Out();
        int n = in.readInt();
        s2.Point[] points = new s2.Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new s2.Point(x, y);
        }
//        StdDraw.setXscale(0, 32767);  //Drawing the x scale
//        StdDraw.setYscale(0, 32767);  //Drawing the y scale
        BruteChecker(points);
    }
}
