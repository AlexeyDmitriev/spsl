package name.admitriev.spsl.io;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputWriter extends PrintWriter {

	public OutputWriter(OutputStream out) {
		super(out);
	}

	public OutputWriter(java.io.Writer writer){
		super(writer);
	}

	public void print(Object... objects){
		for (Object object : objects) {
			print(object);
		}
	}

	public void println(Object... objects){
		print(objects);
		super.println();
	}
}
