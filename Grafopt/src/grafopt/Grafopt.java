
package grafopt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Grafopt {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\Programmings\\Netbeans\\Grafopt\\input.txt"))){
        List<Point> polygon;
        String read;
        while((read = br.readLine())!= null){
            if(read.trim().startsWith("#"))continue;
            
            String[] line = read.split(" ");

            if(line.length == 1){
                int num = Integer.parseInt(line[0]);
                if(num < 3 ) return;
                else{
                    polygon = new ArrayList<>();
                    for(int i = 0; i < num; i++){
                        String[] point = br.readLine().split(" ");
                        polygon.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
                    }
                    centroid(polygon);
                }
            }else{
                
                polygon = new ArrayList<>();
                for(int i = 1; i < line.length-1; i+=2){
                    polygon.add(new Point(Integer.parseInt(line[i]), Integer.parseInt(line[i+1])));
                }
                if(polygon.size() <3) return;
                else{
                    centroid(polygon);
                }
            }
        }
        }catch(IOException e){}
    }
    
    public static void centroid(List<Point>polygon){
        double x = 0.0;
        double y = 0.0;
        
        for(Point p : polygon){
            x += p.x;
            y += p.y;
        }
        x/=polygon.size();
        y/=polygon.size();
//        for(int i = 0; i < polygon.size()-1; i+=2){
//            x+=(polygon.get(i).x + polygon.get(i+1).x)*(polygon.get(i).x * polygon.get(i+1).y - polygon.get(i+1).x * polygon.get(i).y);
//            y+=(polygon.get(i).y + polygon.get(i+1).y)*(polygon.get(i).x * polygon.get(i+1).y - polygon.get(i+1).x * polygon.get(i).y);
//        }
//        
//        double _x = x / 6 * area(polygon);
//        double _y = y / 6 * area(polygon);
        System.err.println(x + " "+ y);
        System.out.println(String.format("%.3f",x)+" "+ String.format("%.3f",y));
    }
    
    private static double area(List<Point>polygon){
        double area = 0.0;
        for(int i = 0; i < polygon.size()-1; i+=2){
            area += polygon.get(i).x * polygon.get(i+1).y - polygon.get(i).y * polygon.get(i+1).x;
        }
        return .5*area;
    }
    
}
