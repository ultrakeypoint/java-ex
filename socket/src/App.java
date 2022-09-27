import java.io.*;
import java.net.*;

public class App {

    public static final String HOST = "127.0.0.1";
    public static final Integer PORT = 9100;

    public static final String ZPL_START = "^XA";
    public static final String ZPL_END = "^XZ";

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(HOST, PORT);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        StringBuffer zpl = new StringBuffer();

        zpl.append(ZPL_START);

        zpl.append("^CFJ,30");
        zpl.append("^FO575,120");
        zpl.append("^FDHello World^FS");

        zpl.append(ZPL_END);
        
        String template = zpl.toString();
        dos.write(template.getBytes());

        dos.flush();
        dos.close();

        socket.close();
    }
}

