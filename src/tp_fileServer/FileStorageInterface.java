package tp_fileServer;

import java.io.File;
import java.util.List;

public interface FileStorageInterface {
	File search(String name);
	void add(File file, String name, List<String> tags);
	void delete(String name);
}
