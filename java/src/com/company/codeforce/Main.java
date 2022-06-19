import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        var pathIn = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\codeforce\\in.txt";
        var pathOut = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\codeforce\\out.txt";

        var inCh = FileChannel.open(Path.of(pathIn));
        var outCh = FileChannel.open(Path.of(pathOut), Set.of(StandardOpenOption.WRITE));

        ByteBuffer buf = ByteBuffer.allocate(5);
        while (inCh.read(buf) != -1) {
            buf.flip();
            outCh.write(buf);
            buf.compact();
        }
    }
}
