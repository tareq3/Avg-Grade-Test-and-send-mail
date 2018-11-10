import com.sun.org.apache.xpath.internal.SourceTree;
import model.Student_Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity {

 public static    ArrayList<Student_Model> students=new ArrayList<>();

    public  static  void main(String[] args){

        //Todo: Read the text file using reader
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {

            String line = br.readLine();

            while (line != null) {
                //Spritting the string at : found
                String[] out =line.split(":");
               students.add(
                       new Student_Model.Builder()
                               .withS_Name(out[0])
                               .withS_Email(out[1])
                               .withS_Grade1(out[2])
                               .withS_Grade2(out[3])
                                .withS_Grade3(out[4])
                               .withS_Grade_Avg(
                                       Float.toString(averageCalculator(
                                               new ArrayList<Integer>(Arrays.asList(
                                                                                            Integer.parseInt(out[2]),
                                                                                                Integer.parseInt(out[3]),
                                                                                                    Integer.parseInt(out[4])
                                                    )
                                               )
                                       ) )
                               )
                               .build());

                //System.out.println(line);

                line = br.readLine(); //reading next line


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Todo: Priting on Console and Sending Mail
        for ( Student_Model sModel: students) {
            System.out.println(sModel.getS_Name() +
                    "\t" + sModel.getS_Grade_Avg());




         //Todo: Without Thread
          new MailController(sModel.getS_Email(), "Hello " + sModel.getS_Name(), "Grade Avg :" + sModel.getS_Grade_Avg())
                  .send();

      /*    //Todo: with Thread
            // creating a thread pool with 10 threads, max alive time is 1 seconds, and linked blocking queue for unlimited queuing of requests.

            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

            // inside your getSalesUserData() method
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        new MailController(sModel.getS_Email(), "Hello " + sModel.getS_Name(), "Grade Avg :" + sModel.getS_Grade_Avg())
                                .send();
                    } catch (Exception e) {
                        System.out.println("error"+ e.getMessage());
                    }
                }
            }); */
        }
    }

    //Todo: Calculate average
    public static float averageCalculator(ArrayList<Integer> args){

        float total=0;
        for ( int arg: args ) {
            total+=arg;
        }
        return total/args.size();
    }

}
