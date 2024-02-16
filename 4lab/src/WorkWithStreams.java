import java.io.*;

public class WorkWithStreams {

    static void outputGeneral(General o, OutputStream out) throws IOException {
        o.output(out);
    }

    static General inputGeneral(InputStream in) throws IOException, MiniSeries.CapacityZeroException {
        DataInputStream dataInputStream = new DataInputStream(in);
        String name = dataInputStream.readUTF();
        int num = dataInputStream.readInt();
        int[] time = new int[num];
        for (int i=0;i<num;i++){
            time[i] = dataInputStream.readInt();
        }
        int titles = dataInputStream.readInt();
        General obj = new MiniSeries(name,time,titles);
        return obj;
    }

    static void writeGeneral (General o, Writer out){
        o.write(out);
    }

    static General readGeneral(Reader in) throws IOException, MiniSeries.CapacityZeroException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        String name = streamTokenizer.sval;
        streamTokenizer.nextToken();
        int num = (int)streamTokenizer.nval;
        int[] time = new int[num];
        for (int i=0;i<num;i++){
            streamTokenizer.nextToken();
            time[i] = (int)streamTokenizer.nval;
        }
        streamTokenizer.nextToken();
        int titles = (int)streamTokenizer.nval;
//        BufferedReader bufferedReader = new BufferedReader(in);
//        String name = bufferedReader.readLine();
//        int num = Integer.parseInt(bufferedReader.readLine());
//        int[] time = new int[num];
//        for (int i=0;i<num;i++){
//            time[i] = Integer.parseInt(bufferedReader.readLine());
//        }
//        int titles = Integer.parseInt(bufferedReader.readLine());
        General obj = new MiniSeries(name,time,titles);
        return obj;
    }

    static void serializeGeneral (General o, OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(o);
    }

    static General deserializeGeneral(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        General obj;
        obj = (General)objectInputStream.readObject();
        return obj;
    }
}
