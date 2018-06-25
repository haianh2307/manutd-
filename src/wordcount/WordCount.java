package wordcount;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {

    //Map: lưu 1 đối tượng dưới dạng Key và Value
    //Ở đây t để đối tượng lưu Key dạng String và Value dạng Integer để lưu từng từ và số lần xuất hiện trong đoạn text
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            //Tạo đối tượng FileReader để lấy file đọc và BufferedReader để đọc file

            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);

            //Khai báo lines để hứng thông tin từ file sau khi đọc
            String lines = null;

            //Kiểm tra nếu file có kí tự -> đọc và in ra
            if ((lines = br.readLine()) != null) {
                System.out.println("Nội dung văn bản : " + lines);
            }

            //Lọc chuỗi đã đọc theo dấu "," và cho tất cả vào 1 mảng
            String words[] = lines.split(",");

            //Duyệt từng phần tử trong mảng
            //Kiểm tra trong map tồn tại từ đấy chưa, nếu có thì tăng count lên 1 (count là số lần xuất hiện) -> put vào map
            //Nếu chưa có, put từ đấy vào map và cho count = 1
            // put = add trong ArrayList
            for (String word : words) {
                if (map.containsKey(word)) {
                    int count = map.get(word) + 1;
                    map.put(word, count);
                } else {
                    map.put(word, 1);
                }
            }

            // Lấy từng entry trong map
            //Entry nghĩa là 1 cặp Key-Value
            System.out.println("================================================");
            System.out.println("Số lần xuất hiện của từng kí tự: ");
            System.out.println();
            for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry);
                System.out.println("----------------");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
