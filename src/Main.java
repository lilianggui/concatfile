import com.llg.EncodingDetect;

import java.io.*;

public class Main {

    public static void main(String args[]){
        concatFile();
    }

    /**
     * 读入TXT文件
     */
    public static void concatFile(){
        File file = new File("C:\\Users\\Lange\\Desktop\\丽海弘金部署\\script\\ddl_script");
        for(File f : file.listFiles()){
            System.out.println("处理文件：" + f.getName() + "...");
            String fileCode = EncodingDetect.detect(f);
            System.out.println("文件编码：" + fileCode);
            StringBuilder sb = new StringBuilder("--" + f.getName() + "\r\n");
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(f), fileCode);
                 BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeFile(sb.toString());
        }
        System.out.println("结束");
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String str) {
        try {
            File writeName = new File("C:\\Users\\Lange\\Desktop\\hhhhh.sql");
            try (FileWriter writer = new FileWriter(writeName, true);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(str);
                out.write("\r\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
